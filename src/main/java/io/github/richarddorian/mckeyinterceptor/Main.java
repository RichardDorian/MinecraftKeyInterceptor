package io.github.richarddorian.mckeyinterceptor;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.KeyPair;
import java.security.ProtectionDomain;
import java.util.Base64;

public class Main {
    public static void premain(String args, Instrumentation instrumentation) {
        instrumentation.addTransformer(new Transformer());
    }

    public static void interceptKeyPair(KeyPair keyPair) {
        System.out.println("-----BEGIN PUBLIC KEY-----\n" + Base64.getMimeEncoder().encodeToString(keyPair.getPublic().getEncoded()) + "\n-----END PUBLIC KEY-----");
        System.out.println("-----BEGIN PRIVATE KEY-----\n" + Base64.getMimeEncoder().encodeToString(keyPair.getPrivate().getEncoded()) + "\n-----END PRIVATE KEY-----");
    }
}

class Transformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if (!className.equals("ng")) return null;

        ClassReader classReader = new ClassReader(classfileBuffer);
        ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_FRAMES);
        ClassNode classNode = new ClassNode();

        classReader.accept(classNode, 0);

        for (MethodNode methodNode : classNode.methods) {
            if (!methodNode.name.equals("b")) continue;

            InsnList insnList = new InsnList();
            insnList.add(new InsnNode(Opcodes.DUP));
            insnList.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "io/github/richarddorian/mckeyinterceptor/Main", "interceptKeyPair", "(Ljava/security/KeyPair;)V", false));

            for (AbstractInsnNode abstractInsnNode : methodNode.instructions) {
                if (abstractInsnNode.getOpcode() != Opcodes.ARETURN) continue;

                methodNode.instructions.insertBefore(abstractInsnNode, insnList);
                break;
            }

            classNode.accept(classWriter);
            return classWriter.toByteArray();
        }

        return null;
    }
}
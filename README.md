# MinecraftKeyInterceptor

Intercept the public and private key on 1.8 Minecraft servers.

# How does it work?

This [Java Agent](https://docs.oracle.com/javase/7/docs/api/java/lang/instrument/package-summary.html) will add a bit of code that will print to the standard output the generated public and private key of the server.

<details>
  <summary>Show example</summary>

```
MinecraftKeyInterceptor - Made for 1.8 Minecraft servers - Thanks to NotEvenJoking for helping me (because I'm dumb)
[11:06:16] [Server thread/INFO]: Starting minecraft server version 1.8.9
[11:06:16] [Server thread/INFO]: Loading properties
[11:06:16] [Server thread/INFO]: Default game type: SURVIVAL
[11:06:16] [Server thread/INFO]: Generating keypair
-----BEGIN PUBLIC KEY-----
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzwjKEv2jvDLxydh+5s/Q27XrmZy7W1oZz1qVm
xvcnHpzyxGixq+h39dWLD+l96xsI2ejaGCQgbU/DEfukFW1WiCORjqihrKecnR2jvruk4YUKH3/F
8Z8IfSIYoSeXT8/MdcGoUray+UYTKymh5970imN816Ksc4lpqL7KQnrJVwIDAQAB
-----END PUBLIC KEY-----
-----BEGIN PRIVATE KEY-----
MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALPCMoS/aO8MvHJ2H7mz9DbteuZn
LtbWhnPWpWbG9ycenPLEaLGr6Hf11YsP6X3rGwjZ6NoYJCBtT8MR+6QVbVaII5GOqKGsp5ydHaO+
u6ThhQoff8Xxnwh9IhihJ5dPz8x1wahStrL5RhMrKaHn3vSKY3zXoqxziWmovspCeslXAgMBAAEC
gYAECH76z06gL8fePKa4LPgoiVbrrvQe2hVJ3M6bCgjLYbywfRHcadzn6Ko7qxcHW/9+DVCHIC4B
MbgC/b+Z0E9CxuA2kl26lpAG6f6yiQIsKsCBoQEFgH5ygORkJT/iNz7KsyvjAVJKWLTK8IYFcnLL
IuEwRQxatW1egZBz9D3yqQJBAPd+2vSYWeXtzSdHDHcA9aUy/BbHPIPXqlE3SbrVERtzyaGCt7x8
nRZQHicaueVf1wcgVIw9PyPnlKYu9SlQd6kCQQC573rxIUw5GxVMh00i8N+9r5/YbcWs/zaXlhvN
rq+y4Bdy3/8WeWwYR78PWLwi7ge7XrJsbJz3CZDPU3apldj/AkEAwdQpqrG+hiJtLzuneXPY7h41
66jxrdezXZPNPHMtyLAv0zvKpeV6KUVpt/poaElc4Anj7UjyMC5n7paMDmUksQJAI7GSc1nGDSxi
0Vcj+rIs8XgWgnDIQuaXb1A0tC51siwMtFPF32Wd16dmSSbqrvXs7A5IyEGtfEsMzpAiNnn6twJB
AO1f2IZIVOZ7MlvOTseLw16+bGhonSlxMaFVOdQ1GPcPRP1zKkBIgIx0K9Ek2/olZ+Sc/0RvkO+Z
SQKFV8OyctU=
-----END PRIVATE KEY-----
[11:06:17] [Server thread/INFO]: Starting Minecraft server on *:25565
[11:06:17] [Server thread/INFO]: Using default channel type
Aug 28, 2022 11:06:17 AM io.netty.util.internal.PlatformDependent <clinit>
INFO: Your platform does not provide complete low-level API for accessing direct buffers reliably. Unless explicitly requested, heap buffer will always be preferred to avoid potential system unstability.
[11:06:17] [Server thread/WARN]: **** SERVER IS RUNNING IN OFFLINE/INSECURE MODE!
[11:06:17] [Server thread/WARN]: The server will make no attempt to authenticate usernames. Beware.
[11:06:17] [Server thread/WARN]: While this makes the game possible to play without internet access, it also opens up the ability for hackers to connect with any username they choose.
[11:06:17] [Server thread/WARN]: To change this, set "online-mode" to "true" in the server.properties file.
[11:06:17] [Server thread/INFO]: Preparing level "world"
[11:06:17] [Server thread/INFO]: Preparing start region for level 0
[11:06:18] [Server thread/INFO]: Done (0.893s)! For help, type "help" or "?"
```

</details>

# How to use it

Usually your launch command should look like this

```bash
$ java -jar server.jar nogui
```

You just have to add the `-javaagent` argument with the path of the jar file. Let's say it's in the same folder as the server the launch command will be

```bash
$ java -javaagent:MinecraftKeyInterceptor.jar -jar server.jar nogui
```

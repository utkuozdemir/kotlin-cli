# kotlin-cli

Simple CLI written in Kotlin that compiles to native code using GraalVM Native Image.

## Introduction

I love [Go](https://go.dev/) - it is simple, compiles to a small, statically linked binary, starts
and runs very fast with minimal resources.

I also love [Kotlin](https://kotlinlang.org/) because it is a very expressive Java-based language
with great features and a strong standard library.

One of the most exciting things going on in the Java world is [GraalVM](https://www.graalvm.org/)
and especially [GraalVM Native Image](https://www.graalvm.org/reference-manual/native-image/). It
compiles Java Bytecode ahead-of-time to produce statically linked binaries similar to Go.

In this project, I write a simple CLI application in Kotlin and compile it using GraalVM Native
Image, trying to get the best of both worlds - write Kotlin, get Go-like binaries.

Working with GraalVM Native Image is not very smooth, it takes long to compile and some things just
don't work with it and/or requires additional configuration (`reflect-config.json` etc.).

The goal of this project is for me to try to do different things with native-image and track its
progression. I can see what works out-of-the-box, what needs additional configuration and what does
not work at all.

It can also serve as an example of how to configure native-image builds for Kotlin in Maven.

List of things I have tried so far:

- Basic file IO :white_check_mark:
- Basic network IO (HTTPS) :white_check_mark:
- Data classes :white_check_mark:
- Log4j2 :x:

## Building

Make sure you have [GraalVM >=21.3.0](https://www.graalvm.org/downloads/) installed.

If you are using Mac & Homebrew:
```bash
brew install --cask graalvm/tap/graalvm-ce-java17 
sudo xattr -r -d com.apple.quarantine /Library/Java/JavaVirtualMachines/graalvm-ce-*
```

Point your `JAVA_HOME` and `GRAALVM_HOME` env variables are set to point to it.  
Example (in your `.bashrc` or `.zshrc`):
```
export GRAALVM_HOME=/Library/Java/JavaVirtualMachines/graalvm-ce-<YOUR_GRAALVM_VERSION>/Contents/Home
export JAVA_HOME=$GRAALVM_HOME
```

To compile, test and produce a .jar (not a native binary):

```bash
./mvnw clean package
```

To compile, run native tests and produce a native binary:

```bash
./mvnw -P native clean package
```

To skip tests:

```bash
./mvnw -DskipTests -P native clean package
```

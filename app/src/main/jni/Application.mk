APP_STL := gnustl_static
APP_ABI := armeabi-v7a x86 # mips arm64-v8a x86_64 mips64
APP_OPTIM := release
APP_PLATFORM := android-16
APP_CPPFLAGS += -Ofast -fexceptions -frtti -std=c++14

NDK_TOOLCHAIN_VERSION := 4.9

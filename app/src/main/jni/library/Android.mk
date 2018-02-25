
LOCAL_PATH := $(call my-dir)

###

include $(CLEAR_VARS)
LOCAL_MODULE := libssl
LOCAL_SRC_FILES := lib/$(TARGET_ARCH_ABI)/libssl.a
include $(PREBUILT_STATIC_LIBRARY)

###

include $(CLEAR_VARS)
LOCAL_MODULE := libcrypto
LOCAL_SRC_FILES := lib/$(TARGET_ARCH_ABI)/libcrypto.a
include $(PREBUILT_STATIC_LIBRARY)

###

include $(CLEAR_VARS)
LOCAL_MODULE := libboost_system
LOCAL_SRC_FILES := lib/$(TARGET_ARCH_ABI)/libboost_system-gcc-mt-1_53.a
include $(PREBUILT_STATIC_LIBRARY)

###

include $(CLEAR_VARS)

LOCAL_MODULE     := libnative

SRC_PATH := $(LOCAL_PATH)/src

LOCAL_SRC_FILES     := $(SRC_PATH)/djinni/support-lib/jni/djinni_main.cpp \
                       $(SRC_PATH)/djinni/support-lib/jni/djinni_support.cpp \

WILDCARD_FILES      := $(wildcard $(SRC_PATH)/gen/cpp/*.c*)
LOCAL_SRC_FILES     += $(WILDCARD_FILES:$(LOCAL_PATH)/%=%)

WILDCARD_FILES      := $(wildcard $(SRC_PATH)/gen/jni/*.cpp)
LOCAL_SRC_FILES     += $(WILDCARD_FILES:$(LOCAL_PATH)/%=%)

WILDCARD_FILES      := $(wildcard $(SRC_PATH)/src/common/aes/*.cpp)
LOCAL_SRC_FILES     += $(WILDCARD_FILES:$(LOCAL_PATH)/%=%)

WILDCARD_FILES      := $(wildcard $(SRC_PATH)/src/common/ecdh/*.cpp)
LOCAL_SRC_FILES     += $(WILDCARD_FILES:$(LOCAL_PATH)/%=%)

WILDCARD_FILES      := $(wildcard $(SRC_PATH)/src/common/entities/*.cpp)
LOCAL_SRC_FILES     += $(WILDCARD_FILES:$(LOCAL_PATH)/%=%)

WILDCARD_FILES      := $(wildcard $(SRC_PATH)/src/common/network/*.cpp)
LOCAL_SRC_FILES     += $(WILDCARD_FILES:$(LOCAL_PATH)/%=%)

WILDCARD_FILES      := $(wildcard $(SRC_PATH)/src/common/tools/*.cpp)
LOCAL_SRC_FILES     += $(WILDCARD_FILES:$(LOCAL_PATH)/%=%)


WILDCARD_FILES      := $(wildcard $(SRC_PATH)/src/client/vm/*.cpp)
LOCAL_SRC_FILES     += $(WILDCARD_FILES:$(LOCAL_PATH)/%=%)

WILDCARD_FILES      := $(wildcard $(SRC_PATH)/src/client/app/*.cpp)
LOCAL_SRC_FILES     += $(WILDCARD_FILES:$(LOCAL_PATH)/%=%)

WILDCARD_FILES      := $(wildcard $(SRC_PATH)/src/client/network/*.cpp)
LOCAL_SRC_FILES     += $(WILDCARD_FILES:$(LOCAL_PATH)/%=%)


LOCAL_C_INCLUDES += $(INCLUDE_PATH) \
                    $(PROTO_PATH)/src \
                    $(SRC_PATH) \
                    $(SRC_PATH)/gen/cpp \
                    $(SRC_PATH)/src/common/aes \
                    $(SRC_PATH)/src/common/ecdh \
                    $(SRC_PATH)/src/common/entities \
                    $(SRC_PATH)/src/common/network \
                    $(SRC_PATH)/src/common/tools \
                    $(SRC_PATH)/src/client/vm \
                    $(SRC_PATH)/src/client/app \
                    $(SRC_PATH)/src/client/network \
                    $(SRC_PATH)/djinni/support-lib/jni \

LOCAL_LDLIBS     += -llog -lz -ldl -ljnigraphics -landroid

LOCAL_CFLAGS     := -O3 \
                    -lssl -lcrypto \



LOCAL_SHARED_LIBRARIES   := libssl \
                            libcrypto \
                            boost_system \
                            libprotobuf-cpp-full-ndk \

LOCAL_PRELINK_MODULE := false

LOCAL_DISABLE_FORMAT_STRING_CHECKS := true

include $(BUILD_SHARED_LIBRARY)

$(call import-module,android/cpufeatures)
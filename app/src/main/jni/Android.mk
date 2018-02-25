LOCAL_PATH := $(call my-dir)

INCLUDE_PATH := $(LOCAL_PATH)/library/include
NATIVE_PATH := $(LOCAL_PATH)/library

PROTO_PATH := $(LOCAL_PATH)/protobuf/src

include $(addprefix $(LOCAL_PATH)/,$(addsuffix /Android.mk, \
            protobuf \
            library \
        ))
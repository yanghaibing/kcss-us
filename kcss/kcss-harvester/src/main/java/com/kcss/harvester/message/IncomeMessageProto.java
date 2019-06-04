package com.kcss.harvester.message;
/**
 * https://developers.google.com/protocol-buffers/docs/overview
 */
public final class IncomeMessageProto {
    private IncomeMessageProto() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    public interface MessageOrBuilder extends
            // @@protoc_insertion_point(interface_extends:com.kcss.harvester.message.Message)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>optional string imei = 1;</code>
         */



        boolean hasImei();

        /**
         * <code>optional string imei = 1;</code>
         */
        String getImei();

        /**
         * <code>optional string imei = 1;</code>
         */
        com.google.protobuf.ByteString
        getImeiBytes();

        /**
         * <code>optional string mobile = 2;</code>
         */
        boolean hasMobile();

        /**
         * <code>optional string mobile = 2;</code>
         */
        String getMobile();

        /**
         * <code>optional string mobile = 2;</code>
         */
        com.google.protobuf.ByteString
        getMobileBytes();

        /**
         * <code>required int64 c_timestamp = 3;</code>
         */
        boolean hasCTimestamp();

        /**
         * <code>required int64 c_timestamp = 3;</code>
         */
        long getCTimestamp();

        /**
         * <code>required .com.kcss.harvester.message.Message.Type type = 4 [default = TRACE];</code>
         */
        boolean hasType();

        /**
         * <code>required .com.kcss.harvester.message.Message.Type type = 4 [default = TRACE];</code>
         */
        com.kcss.harvester.message.IncomeMessageProto.Message.Type getType();

        /**
         * <code>required string body = 5;</code>
         */
        boolean hasBody();

        /**
         * <code>required string body = 5;</code>
         */
        String getBody();

        /**
         * <code>required string body = 5;</code>
         */
        com.google.protobuf.ByteString
        getBodyBytes();
    }

    /**
     * Protobuf type {@code com.kcss.harvester.message.Message}
     */
    public static final class Message extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:com.kcss.harvester.message.Message)
            MessageOrBuilder {
        // Use Message.newBuilder() to construct.
        private Message(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private Message() {
            imei_ = "";
            mobile_ = "";
            cTimestamp_ = 0L;
            type_ = 1;
            body_ = "";
        }

        @Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        private Message(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownField(input, unknownFields,
                                    extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000001;
                            imei_ = bs;
                            break;
                        }
                        case 18: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000002;
                            mobile_ = bs;
                            break;
                        }
                        case 24: {
                            bitField0_ |= 0x00000004;
                            cTimestamp_ = input.readInt64();
                            break;
                        }
                        case 32: {
                            int rawValue = input.readEnum();
                            com.kcss.harvester.message.IncomeMessageProto.Message.Type value = com.kcss.harvester.message.IncomeMessageProto.Message.Type.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(4, rawValue);
                            } else {
                                bitField0_ |= 0x00000008;
                                type_ = rawValue;
                            }
                            break;
                        }
                        case 42: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000010;
                            body_ = bs;
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.kcss.harvester.message.IncomeMessageProto.internal_static_com_kcss_harvester_message_Message_descriptor;
        }

        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.kcss.harvester.message.IncomeMessageProto.internal_static_com_kcss_harvester_message_Message_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.kcss.harvester.message.IncomeMessageProto.Message.class, com.kcss.harvester.message.IncomeMessageProto.Message.Builder.class);
        }

        /**
         * Protobuf enum {@code com.kcss.harvester.message.Message.Type}
         */
        public enum Type
                implements com.google.protobuf.ProtocolMessageEnum {
            /**
             * <code>UNKNOWN = 0;</code>
             */
            UNKNOWN(0),
            /**
             * <code>TRACE = 1;</code>
             */
            TRACE(1),
            ;

            /**
             * <code>UNKNOWN = 0;</code>
             */
            public static final int UNKNOWN_VALUE = 0;
            /**
             * <code>TRACE = 1;</code>
             */
            public static final int TRACE_VALUE = 1;


            public final int getNumber() {
                return value;
            }

            /**
             * @deprecated Use {@link #forNumber(int)} instead.
             */
            @Deprecated
            public static Type valueOf(int value) {
                return forNumber(value);
            }

            public static Type forNumber(int value) {
                switch (value) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return TRACE;
                    default:
                        return null;
                }
            }

            public static com.google.protobuf.Internal.EnumLiteMap<Type>
            internalGetValueMap() {
                return internalValueMap;
            }

            private static final com.google.protobuf.Internal.EnumLiteMap<
                    Type> internalValueMap =
                    new com.google.protobuf.Internal.EnumLiteMap<Type>() {
                        public Type findValueByNumber(int number) {
                            return Type.forNumber(number);
                        }
                    };

            public final com.google.protobuf.Descriptors.EnumValueDescriptor
            getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            public final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptorForType() {
                return getDescriptor();
            }

            public static final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptor() {
                return com.kcss.harvester.message.IncomeMessageProto.Message.getDescriptor().getEnumTypes().get(0);
            }

            private static final Type[] VALUES = values();

            public static Type valueOf(
                    com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException(
                            "EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            private final int value;

            private Type(int value) {
                this.value = value;
            }

            // @@protoc_insertion_point(enum_scope:com.kcss.harvester.message.Message.Type)
        }

        private int bitField0_;
        public static final int IMEI_FIELD_NUMBER = 1;
        private volatile Object imei_;

        /**
         * <code>optional string imei = 1;</code>
         */
        public boolean hasImei() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }

        /**
         * <code>optional string imei = 1;</code>
         */
        public String getImei() {
            Object ref = imei_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    imei_ = s;
                }
                return s;
            }
        }

        /**
         * <code>optional string imei = 1;</code>
         */
        public com.google.protobuf.ByteString
        getImeiBytes() {
            Object ref = imei_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                imei_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int MOBILE_FIELD_NUMBER = 2;
        private volatile Object mobile_;

        /**
         * <code>optional string mobile = 2;</code>
         */
        public boolean hasMobile() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }

        /**
         * <code>optional string mobile = 2;</code>
         */
        public String getMobile() {
            Object ref = mobile_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    mobile_ = s;
                }
                return s;
            }
        }

        /**
         * <code>optional string mobile = 2;</code>
         */
        public com.google.protobuf.ByteString
        getMobileBytes() {
            Object ref = mobile_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                mobile_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int C_TIMESTAMP_FIELD_NUMBER = 3;
        private long cTimestamp_;

        /**
         * <code>required int64 c_timestamp = 3;</code>
         */
        public boolean hasCTimestamp() {
            return ((bitField0_ & 0x00000004) == 0x00000004);
        }

        /**
         * <code>required int64 c_timestamp = 3;</code>
         */
        public long getCTimestamp() {
            return cTimestamp_;
        }

        public static final int TYPE_FIELD_NUMBER = 4;
        private int type_;

        /**
         * <code>required .com.kcss.harvester.message.Message.Type type = 4 [default = TRACE];</code>
         */
        public boolean hasType() {
            return ((bitField0_ & 0x00000008) == 0x00000008);
        }

        /**
         * <code>required .com.kcss.harvester.message.Message.Type type = 4 [default = TRACE];</code>
         */
        public com.kcss.harvester.message.IncomeMessageProto.Message.Type getType() {
            com.kcss.harvester.message.IncomeMessageProto.Message.Type result = com.kcss.harvester.message.IncomeMessageProto.Message.Type.valueOf(type_);
            return result == null ? com.kcss.harvester.message.IncomeMessageProto.Message.Type.TRACE : result;
        }

        public static final int BODY_FIELD_NUMBER = 5;
        private volatile Object body_;

        /**
         * <code>required string body = 5;</code>
         */
        public boolean hasBody() {
            return ((bitField0_ & 0x00000010) == 0x00000010);
        }

        /**
         * <code>required string body = 5;</code>
         */
        public String getBody() {
            Object ref = body_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    body_ = s;
                }
                return s;
            }
        }

        /**
         * <code>required string body = 5;</code>
         */
        public com.google.protobuf.ByteString
        getBodyBytes() {
            Object ref = body_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                body_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;

        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasCTimestamp()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasType()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasBody()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, imei_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, mobile_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                output.writeInt64(3, cTimestamp_);
            }
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
                output.writeEnum(4, type_);
            }
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 5, body_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, imei_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, mobile_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(3, cTimestamp_);
            }
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeEnumSize(4, type_);
            }
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, body_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        private static final long serialVersionUID = 0L;

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.kcss.harvester.message.IncomeMessageProto.Message)) {
                return super.equals(obj);
            }
            com.kcss.harvester.message.IncomeMessageProto.Message other = (com.kcss.harvester.message.IncomeMessageProto.Message) obj;

            boolean result = true;
            result = result && (hasImei() == other.hasImei());
            if (hasImei()) {
                result = result && getImei()
                        .equals(other.getImei());
            }
            result = result && (hasMobile() == other.hasMobile());
            if (hasMobile()) {
                result = result && getMobile()
                        .equals(other.getMobile());
            }
            result = result && (hasCTimestamp() == other.hasCTimestamp());
            if (hasCTimestamp()) {
                result = result && (getCTimestamp()
                        == other.getCTimestamp());
            }
            result = result && (hasType() == other.hasType());
            if (hasType()) {
                result = result && type_ == other.type_;
            }
            result = result && (hasBody() == other.hasBody());
            if (hasBody()) {
                result = result && getBody()
                        .equals(other.getBody());
            }
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasImei()) {
                hash = (37 * hash) + IMEI_FIELD_NUMBER;
                hash = (53 * hash) + getImei().hashCode();
            }
            if (hasMobile()) {
                hash = (37 * hash) + MOBILE_FIELD_NUMBER;
                hash = (53 * hash) + getMobile().hashCode();
            }
            if (hasCTimestamp()) {
                hash = (37 * hash) + C_TIMESTAMP_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                        getCTimestamp());
            }
            if (hasType()) {
                hash = (37 * hash) + TYPE_FIELD_NUMBER;
                hash = (53 * hash) + type_;
            }
            if (hasBody()) {
                hash = (37 * hash) + BODY_FIELD_NUMBER;
                hash = (53 * hash) + getBody().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.kcss.harvester.message.IncomeMessageProto.Message parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static com.kcss.harvester.message.IncomeMessageProto.Message parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static com.kcss.harvester.message.IncomeMessageProto.Message parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static com.kcss.harvester.message.IncomeMessageProto.Message parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static com.kcss.harvester.message.IncomeMessageProto.Message parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static com.kcss.harvester.message.IncomeMessageProto.Message parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static com.kcss.harvester.message.IncomeMessageProto.Message parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static com.kcss.harvester.message.IncomeMessageProto.Message parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static com.kcss.harvester.message.IncomeMessageProto.Message parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static com.kcss.harvester.message.IncomeMessageProto.Message parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(com.kcss.harvester.message.IncomeMessageProto.Message prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(
                BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * Protobuf type {@code com.kcss.harvester.message.Message}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:com.kcss.harvester.message.Message)
                com.kcss.harvester.message.IncomeMessageProto.MessageOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.kcss.harvester.message.IncomeMessageProto.internal_static_com_kcss_harvester_message_Message_descriptor;
            }

            protected FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.kcss.harvester.message.IncomeMessageProto.internal_static_com_kcss_harvester_message_Message_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.kcss.harvester.message.IncomeMessageProto.Message.class, com.kcss.harvester.message.IncomeMessageProto.Message.Builder.class);
            }

            // Construct using com.kcss.harvester.message.IncomeMessageProto.Message.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }

            public Builder clear() {
                super.clear();
                imei_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                mobile_ = "";
                bitField0_ = (bitField0_ & ~0x00000002);
                cTimestamp_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000004);
                type_ = 1;
                bitField0_ = (bitField0_ & ~0x00000008);
                body_ = "";
                bitField0_ = (bitField0_ & ~0x00000010);
                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.kcss.harvester.message.IncomeMessageProto.internal_static_com_kcss_harvester_message_Message_descriptor;
            }

            public com.kcss.harvester.message.IncomeMessageProto.Message getDefaultInstanceForType() {
                return com.kcss.harvester.message.IncomeMessageProto.Message.getDefaultInstance();
            }

            public com.kcss.harvester.message.IncomeMessageProto.Message build() {
                com.kcss.harvester.message.IncomeMessageProto.Message result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.kcss.harvester.message.IncomeMessageProto.Message buildPartial() {
                com.kcss.harvester.message.IncomeMessageProto.Message result = new com.kcss.harvester.message.IncomeMessageProto.Message(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.imei_ = imei_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.mobile_ = mobile_;
                if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
                    to_bitField0_ |= 0x00000004;
                }
                result.cTimestamp_ = cTimestamp_;
                if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
                    to_bitField0_ |= 0x00000008;
                }
                result.type_ = type_;
                if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
                    to_bitField0_ |= 0x00000010;
                }
                result.body_ = body_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return (Builder) super.setField(field, value);
            }

            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.kcss.harvester.message.IncomeMessageProto.Message) {
                    return mergeFrom((com.kcss.harvester.message.IncomeMessageProto.Message) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.kcss.harvester.message.IncomeMessageProto.Message other) {
                if (other == com.kcss.harvester.message.IncomeMessageProto.Message.getDefaultInstance())
                    return this;
                if (other.hasImei()) {
                    bitField0_ |= 0x00000001;
                    imei_ = other.imei_;
                    onChanged();
                }
                if (other.hasMobile()) {
                    bitField0_ |= 0x00000002;
                    mobile_ = other.mobile_;
                    onChanged();
                }
                if (other.hasCTimestamp()) {
                    setCTimestamp(other.getCTimestamp());
                }
                if (other.hasType()) {
                    setType(other.getType());
                }
                if (other.hasBody()) {
                    bitField0_ |= 0x00000010;
                    body_ = other.body_;
                    onChanged();
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                if (!hasCTimestamp()) {
                    return false;
                }
                if (!hasType()) {
                    return false;
                }
                if (!hasBody()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.kcss.harvester.message.IncomeMessageProto.Message parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.kcss.harvester.message.IncomeMessageProto.Message) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private Object imei_ = "";

            /**
             * <code>optional string imei = 1;</code>
             */
            public boolean hasImei() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }

            /**
             * <code>optional string imei = 1;</code>
             */
            public String getImei() {
                Object ref = imei_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        imei_ = s;
                    }
                    return s;
                } else {
                    return (String) ref;
                }
            }

            /**
             * <code>optional string imei = 1;</code>
             */
            public com.google.protobuf.ByteString
            getImeiBytes() {
                Object ref = imei_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (String) ref);
                    imei_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>optional string imei = 1;</code>
             */
            public Builder setImei(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                imei_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional string imei = 1;</code>
             */
            public Builder clearImei() {
                bitField0_ = (bitField0_ & ~0x00000001);
                imei_ = getDefaultInstance().getImei();
                onChanged();
                return this;
            }

            /**
             * <code>optional string imei = 1;</code>
             */
            public Builder setImeiBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                imei_ = value;
                onChanged();
                return this;
            }

            private Object mobile_ = "";

            /**
             * <code>optional string mobile = 2;</code>
             */
            public boolean hasMobile() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }

            /**
             * <code>optional string mobile = 2;</code>
             */
            public String getMobile() {
                Object ref = mobile_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        mobile_ = s;
                    }
                    return s;
                } else {
                    return (String) ref;
                }
            }

            /**
             * <code>optional string mobile = 2;</code>
             */
            public com.google.protobuf.ByteString
            getMobileBytes() {
                Object ref = mobile_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (String) ref);
                    mobile_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>optional string mobile = 2;</code>
             */
            public Builder setMobile(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                mobile_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional string mobile = 2;</code>
             */
            public Builder clearMobile() {
                bitField0_ = (bitField0_ & ~0x00000002);
                mobile_ = getDefaultInstance().getMobile();
                onChanged();
                return this;
            }

            /**
             * <code>optional string mobile = 2;</code>
             */
            public Builder setMobileBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                mobile_ = value;
                onChanged();
                return this;
            }

            private long cTimestamp_;

            /**
             * <code>required int64 c_timestamp = 3;</code>
             */
            public boolean hasCTimestamp() {
                return ((bitField0_ & 0x00000004) == 0x00000004);
            }

            /**
             * <code>required int64 c_timestamp = 3;</code>
             */
            public long getCTimestamp() {
                return cTimestamp_;
            }

            /**
             * <code>required int64 c_timestamp = 3;</code>
             */
            public Builder setCTimestamp(long value) {
                bitField0_ |= 0x00000004;
                cTimestamp_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required int64 c_timestamp = 3;</code>
             */
            public Builder clearCTimestamp() {
                bitField0_ = (bitField0_ & ~0x00000004);
                cTimestamp_ = 0L;
                onChanged();
                return this;
            }

            private int type_ = 1;

            /**
             * <code>required .com.kcss.harvester.message.Message.Type type = 4 [default = TRACE];</code>
             */
            public boolean hasType() {
                return ((bitField0_ & 0x00000008) == 0x00000008);
            }

            /**
             * <code>required .com.kcss.harvester.message.Message.Type type = 4 [default = TRACE];</code>
             */
            public com.kcss.harvester.message.IncomeMessageProto.Message.Type getType() {
                com.kcss.harvester.message.IncomeMessageProto.Message.Type result = com.kcss.harvester.message.IncomeMessageProto.Message.Type.valueOf(type_);
                return result == null ? com.kcss.harvester.message.IncomeMessageProto.Message.Type.TRACE : result;
            }

            /**
             * <code>required .com.kcss.harvester.message.Message.Type type = 4 [default = TRACE];</code>
             */
            public Builder setType(com.kcss.harvester.message.IncomeMessageProto.Message.Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000008;
                type_ = value.getNumber();
                onChanged();
                return this;
            }

            /**
             * <code>required .com.kcss.harvester.message.Message.Type type = 4 [default = TRACE];</code>
             */
            public Builder clearType() {
                bitField0_ = (bitField0_ & ~0x00000008);
                type_ = 1;
                onChanged();
                return this;
            }

            private Object body_ = "";

            /**
             * <code>required string body = 5;</code>
             */
            public boolean hasBody() {
                return ((bitField0_ & 0x00000010) == 0x00000010);
            }

            /**
             * <code>required string body = 5;</code>
             */
            public String getBody() {
                Object ref = body_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        body_ = s;
                    }
                    return s;
                } else {
                    return (String) ref;
                }
            }

            /**
             * <code>required string body = 5;</code>
             */
            public com.google.protobuf.ByteString
            getBodyBytes() {
                Object ref = body_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (String) ref);
                    body_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>required string body = 5;</code>
             */
            public Builder setBody(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000010;
                body_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required string body = 5;</code>
             */
            public Builder clearBody() {
                bitField0_ = (bitField0_ & ~0x00000010);
                body_ = getDefaultInstance().getBody();
                onChanged();
                return this;
            }

            /**
             * <code>required string body = 5;</code>
             */
            public Builder setBodyBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000010;
                body_ = value;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:com.kcss.harvester.message.Message)
        }

        // @@protoc_insertion_point(class_scope:com.kcss.harvester.message.Message)
        private static final com.kcss.harvester.message.IncomeMessageProto.Message DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new com.kcss.harvester.message.IncomeMessageProto.Message();
        }

        public static com.kcss.harvester.message.IncomeMessageProto.Message getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final com.google.protobuf.Parser<Message>
                PARSER = new com.google.protobuf.AbstractParser<Message>() {
            public Message parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new Message(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<Message> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<Message> getParserForType() {
            return PARSER;
        }

        public com.kcss.harvester.message.IncomeMessageProto.Message getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_com_kcss_harvester_message_Message_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_com_kcss_harvester_message_Message_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        String[] descriptorData = {
                "\n\023IncomeMessage.proto\022\032com.kcss.harveste" +
                        "r.message\"\251\001\n\007Message\022\014\n\004imei\030\001 \001(\t\022\016\n\006m" +
                        "obile\030\002 \001(\t\022\023\n\013c_timestamp\030\003 \002(\003\022=\n\004type" +
                        "\030\004 \002(\0162(.com.kcss.harvester.message.Mess" +
                        "age.Type:\005TRACE\022\014\n\004body\030\005 \002(\t\"\036\n\004Type\022\013\n" +
                        "\007UNKNOWN\020\000\022\t\n\005TRACE\020\001B0\n\032com.kcss.harves" +
                        "ter.messageB\022IncomeMessageProto"
        };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
                    public com.google.protobuf.ExtensionRegistry assignDescriptors(
                            com.google.protobuf.Descriptors.FileDescriptor root) {
                        descriptor = root;
                        return null;
                    }
                };
        com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        }, assigner);
        internal_static_com_kcss_harvester_message_Message_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_com_kcss_harvester_message_Message_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_com_kcss_harvester_message_Message_descriptor,
                new String[]{"Imei", "Mobile", "CTimestamp", "Type", "Body",});
    }

    // @@protoc_insertion_point(outer_class_scope)
}

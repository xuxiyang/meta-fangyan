toolchain_create_sdk_env_script_append() {
    echo 'alias opkg="opkg -o $OECORE_TARGET_SYSROOT -f $OECORE_TARGET_SYSROOT/etc/opkg.conf" ' >> $script
    echo 'alias opkg-native="opkg -f $OECORE_NATIVE_SYSROOT/etc/opkg.conf" ' >> $script
}

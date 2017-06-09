mount -t tmpfs tmpfs /dev

mknod /dev/null c 1 3
mknod /dev/zero c 1 5
mknod /dev/console c 5 1

mknod /dev/fb0 c 29 0
mknod /dev/galcore c 199 0

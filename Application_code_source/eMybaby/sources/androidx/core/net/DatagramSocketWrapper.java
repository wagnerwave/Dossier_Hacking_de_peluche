package androidx.core.net;

import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;

public class DatagramSocketWrapper extends Socket {

    public static class DatagramSocketImplWrapper extends SocketImpl {
        public DatagramSocketImplWrapper(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) {
            this.localport = datagramSocket.getLocalPort();
            this.fd = fileDescriptor;
        }

        public void accept(SocketImpl socketImpl) {
            throw new UnsupportedOperationException();
        }

        public int available() {
            throw new UnsupportedOperationException();
        }

        public void bind(InetAddress inetAddress, int i) {
            throw new UnsupportedOperationException();
        }

        public void close() {
            throw new UnsupportedOperationException();
        }

        public void connect(String str, int i) {
            throw new UnsupportedOperationException();
        }

        public void connect(InetAddress inetAddress, int i) {
            throw new UnsupportedOperationException();
        }

        public void connect(SocketAddress socketAddress, int i) {
            throw new UnsupportedOperationException();
        }

        public void create(boolean z) {
            throw new UnsupportedOperationException();
        }

        public InputStream getInputStream() {
            throw new UnsupportedOperationException();
        }

        public Object getOption(int i) {
            throw new UnsupportedOperationException();
        }

        public OutputStream getOutputStream() {
            throw new UnsupportedOperationException();
        }

        public void listen(int i) {
            throw new UnsupportedOperationException();
        }

        public void sendUrgentData(int i) {
            throw new UnsupportedOperationException();
        }

        public void setOption(int i, Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    public DatagramSocketWrapper(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) {
        super(new DatagramSocketImplWrapper(datagramSocket, fileDescriptor));
    }
}

package a.d.a.a.i.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public final class x9 extends SSLSocket {

    /* renamed from: a  reason: collision with root package name */
    public final SSLSocket f2626a;

    public x9(SSLSocket sSLSocket) {
        this.f2626a = sSLSocket;
    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f2626a.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void bind(SocketAddress socketAddress) {
        this.f2626a.bind(socketAddress);
    }

    public final synchronized void close() {
        this.f2626a.close();
    }

    public final void connect(SocketAddress socketAddress) {
        this.f2626a.connect(socketAddress);
    }

    public final void connect(SocketAddress socketAddress, int i) {
        this.f2626a.connect(socketAddress, i);
    }

    public final boolean equals(Object obj) {
        return this.f2626a.equals(obj);
    }

    public final SocketChannel getChannel() {
        return this.f2626a.getChannel();
    }

    public final boolean getEnableSessionCreation() {
        return this.f2626a.getEnableSessionCreation();
    }

    public final String[] getEnabledCipherSuites() {
        return this.f2626a.getEnabledCipherSuites();
    }

    public final String[] getEnabledProtocols() {
        return this.f2626a.getEnabledProtocols();
    }

    public final InetAddress getInetAddress() {
        return this.f2626a.getInetAddress();
    }

    public final InputStream getInputStream() {
        return this.f2626a.getInputStream();
    }

    public final boolean getKeepAlive() {
        return this.f2626a.getKeepAlive();
    }

    public final InetAddress getLocalAddress() {
        return this.f2626a.getLocalAddress();
    }

    public final int getLocalPort() {
        return this.f2626a.getLocalPort();
    }

    public final SocketAddress getLocalSocketAddress() {
        return this.f2626a.getLocalSocketAddress();
    }

    public final boolean getNeedClientAuth() {
        return this.f2626a.getNeedClientAuth();
    }

    public final boolean getOOBInline() {
        return this.f2626a.getOOBInline();
    }

    public final OutputStream getOutputStream() {
        return this.f2626a.getOutputStream();
    }

    public final int getPort() {
        return this.f2626a.getPort();
    }

    public final synchronized int getReceiveBufferSize() {
        return this.f2626a.getReceiveBufferSize();
    }

    public final SocketAddress getRemoteSocketAddress() {
        return this.f2626a.getRemoteSocketAddress();
    }

    public final boolean getReuseAddress() {
        return this.f2626a.getReuseAddress();
    }

    public final synchronized int getSendBufferSize() {
        return this.f2626a.getSendBufferSize();
    }

    public final SSLSession getSession() {
        return this.f2626a.getSession();
    }

    public final int getSoLinger() {
        return this.f2626a.getSoLinger();
    }

    public final synchronized int getSoTimeout() {
        return this.f2626a.getSoTimeout();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f2626a.getSupportedCipherSuites();
    }

    public final String[] getSupportedProtocols() {
        return this.f2626a.getSupportedProtocols();
    }

    public final boolean getTcpNoDelay() {
        return this.f2626a.getTcpNoDelay();
    }

    public final int getTrafficClass() {
        return this.f2626a.getTrafficClass();
    }

    public final boolean getUseClientMode() {
        return this.f2626a.getUseClientMode();
    }

    public final boolean getWantClientAuth() {
        return this.f2626a.getWantClientAuth();
    }

    public final boolean isBound() {
        return this.f2626a.isBound();
    }

    public final boolean isClosed() {
        return this.f2626a.isClosed();
    }

    public final boolean isConnected() {
        return this.f2626a.isConnected();
    }

    public final boolean isInputShutdown() {
        return this.f2626a.isInputShutdown();
    }

    public final boolean isOutputShutdown() {
        return this.f2626a.isOutputShutdown();
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f2626a.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void sendUrgentData(int i) {
        this.f2626a.sendUrgentData(i);
    }

    public final void setEnableSessionCreation(boolean z) {
        this.f2626a.setEnableSessionCreation(z);
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        this.f2626a.setEnabledCipherSuites(strArr);
    }

    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null && Arrays.asList(strArr).contains("SSLv3")) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.f2626a.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove("SSLv3");
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.f2626a.setEnabledProtocols(strArr);
    }

    public final void setKeepAlive(boolean z) {
        this.f2626a.setKeepAlive(z);
    }

    public final void setNeedClientAuth(boolean z) {
        this.f2626a.setNeedClientAuth(z);
    }

    public final void setOOBInline(boolean z) {
        this.f2626a.setOOBInline(z);
    }

    public final void setPerformancePreferences(int i, int i2, int i3) {
        this.f2626a.setPerformancePreferences(i, i2, i3);
    }

    public final synchronized void setReceiveBufferSize(int i) {
        this.f2626a.setReceiveBufferSize(i);
    }

    public final void setReuseAddress(boolean z) {
        this.f2626a.setReuseAddress(z);
    }

    public final synchronized void setSendBufferSize(int i) {
        this.f2626a.setSendBufferSize(i);
    }

    public final void setSoLinger(boolean z, int i) {
        this.f2626a.setSoLinger(z, i);
    }

    public final synchronized void setSoTimeout(int i) {
        this.f2626a.setSoTimeout(i);
    }

    public final void setTcpNoDelay(boolean z) {
        this.f2626a.setTcpNoDelay(z);
    }

    public final void setTrafficClass(int i) {
        this.f2626a.setTrafficClass(i);
    }

    public final void setUseClientMode(boolean z) {
        this.f2626a.setUseClientMode(z);
    }

    public final void setWantClientAuth(boolean z) {
        this.f2626a.setWantClientAuth(z);
    }

    public final void shutdownInput() {
        this.f2626a.shutdownInput();
    }

    public final void shutdownOutput() {
        this.f2626a.shutdownOutput();
    }

    public final void startHandshake() {
        this.f2626a.startHandshake();
    }

    public final String toString() {
        return this.f2626a.toString();
    }
}

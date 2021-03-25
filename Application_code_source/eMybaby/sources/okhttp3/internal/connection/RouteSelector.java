package okhttp3.internal.connection;

import a.a.a.a.a;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

public final class RouteSelector {
    public final Address address;
    public List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
    public InetSocketAddress lastInetSocketAddress;
    public Proxy lastProxy;
    public int nextInetSocketAddressIndex;
    public int nextProxyIndex;
    public final List<Route> postponedRoutes = new ArrayList();
    public List<Proxy> proxies = Collections.emptyList();
    public final RouteDatabase routeDatabase;

    public RouteSelector(Address address2, RouteDatabase routeDatabase2) {
        this.address = address2;
        this.routeDatabase = routeDatabase2;
        resetNextProxy(address2.url(), address2.proxy());
    }

    public static String getHostString(InetSocketAddress inetSocketAddress) {
        InetAddress address2 = inetSocketAddress.getAddress();
        return address2 == null ? inetSocketAddress.getHostName() : address2.getHostAddress();
    }

    private boolean hasNextInetSocketAddress() {
        return this.nextInetSocketAddressIndex < this.inetSocketAddresses.size();
    }

    private boolean hasNextPostponed() {
        return !this.postponedRoutes.isEmpty();
    }

    private boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private InetSocketAddress nextInetSocketAddress() {
        if (hasNextInetSocketAddress()) {
            List<InetSocketAddress> list = this.inetSocketAddresses;
            int i = this.nextInetSocketAddressIndex;
            this.nextInetSocketAddressIndex = i + 1;
            return list.get(i);
        }
        StringBuilder n = a.n("No route to ");
        n.append(this.address.url().host());
        n.append("; exhausted inet socket addresses: ");
        n.append(this.inetSocketAddresses);
        throw new SocketException(n.toString());
    }

    private Route nextPostponed() {
        return this.postponedRoutes.remove(0);
    }

    private Proxy nextProxy() {
        if (hasNextProxy()) {
            List<Proxy> list = this.proxies;
            int i = this.nextProxyIndex;
            this.nextProxyIndex = i + 1;
            Proxy proxy = list.get(i);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        StringBuilder n = a.n("No route to ");
        n.append(this.address.url().host());
        n.append("; exhausted proxy configurations: ");
        n.append(this.proxies);
        throw new SocketException(n.toString());
    }

    private void resetNextInetSocketAddress(Proxy proxy) {
        String str;
        int i;
        this.inetSocketAddresses = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.address.url().host();
            i = this.address.url().port();
        } else {
            SocketAddress address2 = proxy.address();
            if (address2 instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address2;
                str = getHostString(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                StringBuilder n = a.n("Proxy.address() is not an InetSocketAddress: ");
                n.append(address2.getClass());
                throw new IllegalArgumentException(n.toString());
            }
        }
        if (i < 1 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.inetSocketAddresses.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            List<InetAddress> lookup = this.address.dns().lookup(str);
            int size = lookup.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.inetSocketAddresses.add(new InetSocketAddress(lookup.get(i2), i));
            }
        }
        this.nextInetSocketAddressIndex = 0;
    }

    private void resetNextProxy(HttpUrl httpUrl, Proxy proxy) {
        List<Proxy> immutableList;
        if (proxy != null) {
            immutableList = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.address.proxySelector().select(httpUrl.uri());
            if (select == null || select.isEmpty()) {
                immutableList = Util.immutableList((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                immutableList = Util.immutableList(select);
            }
        }
        this.proxies = immutableList;
        this.nextProxyIndex = 0;
    }

    public void connectFailed(Route route, IOException iOException) {
        if (!(route.proxy().type() == Proxy.Type.DIRECT || this.address.proxySelector() == null)) {
            this.address.proxySelector().connectFailed(this.address.url().uri(), route.proxy().address(), iOException);
        }
        this.routeDatabase.failed(route);
    }

    public boolean hasNext() {
        return hasNextInetSocketAddress() || hasNextProxy() || hasNextPostponed();
    }

    public Route next() {
        if (!hasNextInetSocketAddress()) {
            if (hasNextProxy()) {
                this.lastProxy = nextProxy();
            } else if (hasNextPostponed()) {
                return nextPostponed();
            } else {
                throw new NoSuchElementException();
            }
        }
        InetSocketAddress nextInetSocketAddress = nextInetSocketAddress();
        this.lastInetSocketAddress = nextInetSocketAddress;
        Route route = new Route(this.address, this.lastProxy, nextInetSocketAddress);
        if (!this.routeDatabase.shouldPostpone(route)) {
            return route;
        }
        this.postponedRoutes.add(route);
        return next();
    }
}

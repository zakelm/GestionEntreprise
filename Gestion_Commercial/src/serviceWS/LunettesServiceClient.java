
package serviceWS;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import javax.xml.namespace.QName;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.jaxb2.JaxbTypeRegistry;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;

public class LunettesServiceClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    public LunettesServiceClient() {
        create0();
        Endpoint LunettesServicePortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://service", "LunettesServicePortTypeLocalEndpoint"), new QName("http://service", "LunettesServicePortTypeLocalBinding"), "xfire.local://LunettesService");
        endpoints.put(new QName("http://service", "LunettesServicePortTypeLocalEndpoint"), LunettesServicePortTypeLocalEndpointEP);
        Endpoint LunettesServiceHttpPortEP = service0 .addEndpoint(new QName("http://service", "LunettesServiceHttpPort"), new QName("http://service", "LunettesServiceHttpBinding"), "http://pc-zakaria:8080/siegeFinal/services/LunettesService");
        endpoints.put(new QName("http://service", "LunettesServiceHttpPort"), LunettesServiceHttpPortEP);
    }

    public Object getEndpoint(Endpoint endpoint) {
        try {
            return proxyFactory.create((endpoint).getBinding(), (endpoint).getUrl());
        } catch (MalformedURLException e) {
            throw new XFireRuntimeException("Invalid URL", e);
        }
    }

    public Object getEndpoint(QName name) {
        Endpoint endpoint = ((Endpoint) endpoints.get((name)));
        if ((endpoint) == null) {
            throw new IllegalStateException("No such endpoint!");
        }
        return getEndpoint((endpoint));
    }

    public Collection getEndpoints() {
        return endpoints.values();
    }

    private void create0() {
        TransportManager tm = (org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager());
        HashMap props = new HashMap();
        props.put("annotations.allow.interface", true);
        AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), tm, new AegisBindingProvider(new JaxbTypeRegistry()));
        asf.setBindingCreationEnabled(false);
        service0 = asf.create((serviceWS.LunettesServicePortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://service", "LunettesServiceHttpBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://service", "LunettesServicePortTypeLocalBinding"), "urn:xfire:transport:local");
        }
    }

    public LunettesServicePortType getLunettesServicePortTypeLocalEndpoint() {
        return ((LunettesServicePortType)(this).getEndpoint(new QName("http://service", "LunettesServicePortTypeLocalEndpoint")));
    }

    public LunettesServicePortType getLunettesServicePortTypeLocalEndpoint(String url) {
        LunettesServicePortType var = getLunettesServicePortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public LunettesServicePortType getLunettesServiceHttpPort() {
        return ((LunettesServicePortType)(this).getEndpoint(new QName("http://service", "LunettesServiceHttpPort")));
    }

    public LunettesServicePortType getLunettesServiceHttpPort(String url) {
        LunettesServicePortType var = getLunettesServiceHttpPort();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public static void main(String[] args) {
        

        LunettesServiceClient client = new LunettesServiceClient();
        
		//create a default service endpoint
        LunettesServicePortType service = client.getLunettesServiceHttpPort();
        
		//TODO: Add custom client code here
        		//
        		//service.yourServiceOperationHere();
        
		System.out.println("test client completed"+service.selectLunettes().getArrayOfString().get(2).getString());
        		System.exit(0);
    }

}

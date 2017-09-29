
package serviceWS;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import service.ArrayOfArrayOfString;

@WebService(name = "LunettesServicePortType", targetNamespace = "http://service")
@SOAPBinding(use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface LunettesServicePortType {

	@WebMethod(operationName = "selectLunettes", action = "")
	@WebResult(name = "out", targetNamespace = "http://service")
	public ArrayOfArrayOfString selectLunettes();

	@WebMethod(operationName = "example", action = "")
	@WebResult(name = "out", targetNamespace = "http://service")
	public String example(
			@WebParam(name = "in0", targetNamespace = "http://service") String in0);

	@WebMethod(operationName = "SaveCMD1", action = "")
	@WebResult(name = "out", targetNamespace = "http://service")
	public String saveCMD1(
			@WebParam(name = "in0", targetNamespace = "http://service") int in0,
			@WebParam(name = "in1", targetNamespace = "http://service") String in1,
			@WebParam(name = "in2", targetNamespace = "http://service") int in2,
			@WebParam(name = "in3", targetNamespace = "http://service") int in3);

}

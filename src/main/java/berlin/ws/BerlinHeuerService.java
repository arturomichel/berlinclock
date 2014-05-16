package berlin.ws;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import berlin.clock.BerlinHeuer;
import berlin.clock.BerlinHeuerProvider;

@Path("berlinHeuer")
public class BerlinHeuerService {

	
	@GET
	@Path("/toBerlin/{time}")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public Response toBerlin(@PathParam("time") String time){
		BerlinHeuer berlin = BerlinHeuerProvider.toBerlinString(time);
		berlin.setProvided(true);
		return Response.status(Status.OK).entity(berlin).build();
		
	}
	
	@GET
	@Path("/getTime")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public Response getTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time = sdf.format(new Date());
		BerlinHeuer berlin = BerlinHeuerProvider.toBerlinString(time);
		berlin.setProvided(false);
		return Response.status(Status.OK).entity(berlin).build();
	}
}

package berlin.ws;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import berlin.clock.BerlinClock;
import berlin.clock.BerlinClockBuilder;

@Path("berlinHeuer")
public class BerlinClockService {

	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	@GET
	@Path("/getTime")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public Response getTime(@QueryParam("time") String time){
		if(time == null)
			time = sdf.format(new Date());
		BerlinClock berlin = BerlinClockBuilder.build(time);
		return Response.status(Status.OK).entity(berlin).build();
		
	}
	
	/*@GET
	@Path("/getTime")
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public Response getTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time = sdf.format(new Date());
		BerlinHeuer berlin = BerlinHeuerParser.toBerlinString(time);
		berlin.setProvided(false);
		return Response.status(Status.OK).entity(berlin).build();
	}*/
}

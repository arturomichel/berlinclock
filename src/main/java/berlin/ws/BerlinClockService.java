package berlin.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import berlin.clock.BerlinClock;
import berlin.clock.Clock;

@Path("berlinClock")
public class BerlinClockService {

	@GET
	@Path("/getTime")
	@Produces("application/json; charset=utf-8")
	public Response getTime(@DefaultValue(value="") @QueryParam("time") String time) {
		
		BerlinClock berlin = null;
		
		if(!"".equals(time)) {
			berlin = Clock.getInstance().getTimeBerlinFormat(time);
		} else {
			berlin = Clock.getInstance().getTimeBerlinFormat();
		}
		
		return Response.status(Status.OK).entity(berlin).build();
		
	}
	
	@GET
	@Path("/setOffset")
	@Produces("application/json; charset=utf-8")
	public Response setOffset(@DefaultValue(value="") @QueryParam("offset") String offset) {
		
		if(!"".equals(offset)) {
			Clock.getInstance().setOffset(offset);
		}
		
		String message = Clock.getInstance().getOffset();
		
		return Response.status(Status.OK).entity(message).build();
		
	}
}

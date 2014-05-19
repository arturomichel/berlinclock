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
	@Consumes("application/json; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public Response getTime(@DefaultValue(value="") @QueryParam("offset") String offset) {
		if(!"".equals(offset)) {
			Clock.getInstance().setTimeZone(offset);
		}
		
		BerlinClock berlin = Clock.getInstance().getBerlinClock();
		return Response.status(Status.OK).entity(berlin).build();
		
	}
	
}

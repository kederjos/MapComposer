package edu.oregonstate.carto.mapcomposer.server;

import edu.oregonstate.carto.mapcomposer.Layer;
import edu.oregonstate.carto.mapcomposer.Map;
import java.awt.image.BufferedImage;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Nicholas Hallahan nick@theoutpost.io
 */
@Path("example1/{z}/{x}/{y}.png")
public class RestAPIExample1 {
    
    @Context
    private UriInfo context;
    
    private Map map;
    private Layer layer1, layer2;

    public RestAPIExample1() {
        map = new Map();
        layer1 = new Layer("Esri", "http://services.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}");
        layer2 = new Layer("Stamen", "http://tile.stamen.com/watercolor/{z}/{x}/{y}.png");
        map.addLayer(layer1);
        map.addLayer(layer2);
    }

    @GET
    @Produces("image/png")
    public Response generateTile(
            @PathParam("z") int z,
            @PathParam("x") int x,
            @PathParam("y") int y,
            @QueryParam("first") String first,
            @QueryParam("second") String second,
            @QueryParam("third") String third) {

        BufferedImage img = map.generateTile(z, x, y);

        return Response.ok(img).build();
    }
}

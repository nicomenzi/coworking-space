package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.service.DeviceService;

@Path("/device")
@Tag(name = "Device", description = "Handling of Device")
public class DeviceController {

    
}

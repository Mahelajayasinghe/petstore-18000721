package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/v1/pets")
@Produces("application/json")
public class PetResource {
	List<Pet> pets = new ArrayList<Pet>();
	List<PetType> petTypes = new ArrayList<PetType>();

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "All Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@GET
	@Path("/")
	public Response getPets() {

		Pet pet1 = new Pet();
		pet1.setPetId(1);
		pet1.setPetAge(3);
		pet1.setPetName("Boola");
		pet1.setPetType("Dog");

		Pet pet2 = new Pet();
		pet2.setPetId(2);
		pet2.setPetAge(4);
		pet2.setPetName("Sudda");
		pet2.setPetType("Cat");

		Pet pet3 = new Pet();
		pet3.setPetId(3);
		pet3.setPetAge(2);
		pet3.setPetName("Peththappu");
		pet3.setPetType("Bird");

		pets.add(pet1);
		pets.add(pet2);
		pets.add(pet3);
		return Response.ok(pets).build();
	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	@GET
	@Path("{petId}")
	public Response getPet(@PathParam("petId") int petId) {
		if (petId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}

		Pet pet = new Pet();

		for (Pet value : pets) {
			if (value.getPetId() == petId) {
				pet.setPetId(value.getPetId());
				pet.setPetAge(value.getPetAge());
				pet.setPetName(value.getPetName());
				pet.setPetType(value.getPetType());
			}
		}

		return Response.ok(pet).build();
		
	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for name", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	@GET
	@Path("/{petName}")
	public Response getPetbyName(@PathParam("petName") String petName) {

		Pet pet = new Pet();

		for (Pet value : pets) {
			if (petName.equals(value.getPetName())) {
				pet.setPetId(value.getPetId());
				pet.setPetAge(value.getPetAge());
				pet.setPetName(value.getPetName());
				pet.setPetType(value.getPetType());
			}
		}

		return Response.ok(pet).build();

	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Create Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPets(Pet pet) {
		int arraysize = pets.size();
		int index = arraysize+1;
		Pet newpet = pet;
		newpet.setPetId(index);
		pets.add(newpet);
		return Response.ok(pets).build();
	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Update pet", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),})
	@PUT
	@Path("{petId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePet(@PathParam("petId") int petId,Pet pet) {
		if (petId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}

		for (Pet value : pets) {
			if (value.getPetId() == petId) {
				if(pet.getPetAge()!=null){
					value.setPetAge(pet.getPetAge());
				}
				if(pet.getPetName()!=null){
					value.setPetName(pet.getPetName());
				}
				if(pet.getPetType()!=null) {
					value.setPetType(pet.getPetType());
				}
			}
		}

		return Response.ok(pets).build();

	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Delete pet", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),})
	@DELETE
	@Path("{petId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePet(@PathParam("petId") int petId) {
		if (petId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}

		pets.removeIf(value -> value.getPetId() == petId);

		return Response.ok(pets).build();

	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "All Pet Types", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))) })
	@GET
	@Path("/pettypes")
	public Response getPetTypes() {

		return Response.ok(petTypes).build();
	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "PetType for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),
			@APIResponse(responseCode = "404", description = "No PetType found for the id.") })
	@GET
	@Path("/pettypes/{petTypeId}")
	public Response getPetTypes(@PathParam("petTypeId") int petTypeId) {
		if (petTypeId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}

		PetType petType = new PetType();

		for (PetType value : petTypes) {
			if (value.getPetTypeId() == petTypeId) {
				petType.setPetTypeId(value.getPetTypeId());
				petType.setPetType(value.getPetType());
			}
		}

		return Response.ok(petType).build();

	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Create Pet Type", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))) })
	@POST
	@Path("/pettypes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPetType(PetType petType) {
		int arraysize = petTypes.size();
		int index = arraysize+1;
		PetType newpetType = petType;
		newpetType.setPetTypeId(index);
		petTypes.add(newpetType);
		return Response.ok(petTypes).build();
	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Delete pet", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),})
	@DELETE
	@Path("/pettypes/{petTypeId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePetType(@PathParam("petTypeId") int petTypeId) {
		if (petTypeId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}

		petTypes.removeIf(value -> value.getPetTypeId() == petTypeId);

		return Response.ok(petTypes).build();

	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Update petType", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),})
	@PUT
	@Path("pettypes/{petTypeId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePetType(@PathParam("petTypeId") int petTypeId,Pet petType) {
		if (petTypeId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}

		for (PetType value : petTypes) {
			if (value.getPetTypeId() == petTypeId) {
				if(petType.getPetType()!=null){
					value.setPetType(petType.getPetType());
				}
			}
		}

		return Response.ok(petTypes).build();

	}
}

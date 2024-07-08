package com.projuris.controller;



import com.projuris.model.LoginRequest;
import com.projuris.model.RegisterRequest;
import com.projuris.service.AuthService;
import com.projuris.service.AuthenticationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Log
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/auth", produces = {"application/json"} )
@Tag(name = " Controller for auth")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "403", description = "Forbidden"),
        @ApiResponse(responseCode = "404", description = "Not Found"),
        @ApiResponse(responseCode = "405", description = "Method Not Allowed"),
        @ApiResponse(responseCode = "412", description = "Precondition Failed"),
        @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
        @ApiResponse(responseCode = "422", description = "Unprocessable Entity"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
})
public class AuthController {


    private final AuthService authService;


    @Operation(method = "POST", summary = "Register a user", description = "Register a user.")
    @ApiResponse(responseCode = "201", description = "CREATED")
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        log.info("Started, signing up a user...");
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(method = "POST", summary = "Register a user", description = "Register a user.")
    @ApiResponse(responseCode = "201", description = "CREATED")
    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        log.info("Started, logging in a user...");
        return authService.login(loginRequest);
    }
}
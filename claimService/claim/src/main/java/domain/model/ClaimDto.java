package domain.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity @Getter @Setter @AllArgsConstructor
public class ClaimDto {

    // Getters and setters
    @NotBlank(message="claim ID is required")
    @JsonProperty("claimId")
    private String claimId;

    @NotBlank(message="policy Number is required")
    @JsonProperty("policyNumber")
    private String policyNumber;

    @NotBlank(message="claim Type is required")
    @JsonProperty("claimType")
    private String claimType; // e.g., Health, Vehicle, Property

    @NotBlank(message="claim Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Claim amount must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Invalid claim amount format")
    @JsonProperty("claimAmount")
    private Double claimAmount;

    @NotBlank(message="Incident Description is required")
    @JsonProperty("incidentDescription")
    private String incidentDescription;

    @NotBlank(message="incident Date is required")
    @PastOrPresent(message = "incident date cannot be in future")
    @JsonProperty("incidentDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate incidentDate;

    @NotBlank(message="Reported Date is required")
    @PastOrPresent(message = "Reported date cannot be in future")
    @JsonProperty("reportedDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate reportedDate;

    @Email(message = "Invalid email format")
    @JsonProperty("contactEmail")
    private String contactEmail;

    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Invalid contact number")
    @JsonProperty("contactPhone")
    private String contactPhone;

}
//{
//        "claimId": "CLM-1001",
//        "policyNumber": "POL-98765",
//        "claimType": "Health",
//        "claimAmount": 15000.50,
//        "incidentDescription": "Hospitalization due to illness",
//        "incidentDate": "2025-08-05",
//        "reportedDate": "2025-08-06",
//        "claimStatus": "Submitted",
//        "contactEmail": "john.doe@example.com",
//        "contactPhone": "+91-9876543210"
//        }

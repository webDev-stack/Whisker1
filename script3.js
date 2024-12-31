// Wait until DOM is loaded
document.addEventListener("DOMContentLoaded", () => {
    // List Pets Functionality
    const listPetsForm = document.getElementById("list-pets-form");
    listPetsForm.addEventListener("submit", (event) => {
        event.preventDefault();
        const petName = document.getElementById("pet-name").value;
        const petBreed = document.getElementById("pet-breed").value;
        const petAge = document.getElementById("pet-age").value;

        // Confirmation Message
        const confirmationMessage = document.getElementById("list-pets-confirmation");
        confirmationMessage.textContent = `Pet "${petName}" listed successfully!`;
        listPetsForm.reset();
    });

    // Interact with Adopters Functionality
    const interactionForm = document.getElementById("interaction-form");
    interactionForm.addEventListener("submit", (event) => {
        event.preventDefault();
        const message = document.getElementById("interaction-message").value;
        const feedback = document.getElementById("feedback").value;

        // Confirmation Message
        const confirmationMessage = document.getElementById("interaction-confirmation");
        confirmationMessage.textContent = "Message and feedback sent successfully!";
        interactionForm.reset();
    });

    // Track Adoption Applications Functionality
    const applicationForm = document.getElementById("application-form");
    applicationForm.addEventListener("submit", (event) => {
        event.preventDefault();
        const applicationID = document.getElementById("application-id").value;

        // Simulate Application Tracking
        const statusMessage = document.getElementById("application-status");
        if (applicationID === "12345") {
            statusMessage.textContent = "Application Approved!";
        } else {
            statusMessage.textContent = "Application is under review.";
        }
        applicationForm.reset();
    });
});

//Delete Meal Button below 
export function initializeDeleteButtons() {
    const deleteButtons = document.querySelectorAll("[id^='deleteBtn-']"); // Select buttons with IDs starting with 'deleteBtn-'

    deleteButtons.forEach((button) => {
        button.addEventListener("click", async () => {
            const mealId = button.id.replace("deleteBtn-", ""); // Extract meal ID from the button ID

            if (!mealId) {
                console.error("Meal ID is null or undefined");
                return;
            }

            const confirmDelete = confirm("Are you sure you want to delete this meal?");
            if (!confirmDelete) {
                return;
            }

            try {
                const response = await fetch(`/api/meal/${mealId}`, {
                    method: "DELETE",
                    headers: {
                        "Content-Type": "application/json",
                    },
                });

                if (response.ok) {
                    const closestTR = button.closest("tr");     //gets closest tableRow and deletes it, have to redo it for accordion
                    if (closestTR) {
                        closestTR.remove();
                    }
                } else {
                    console.error("Failed to delete the meal");
                }
            } catch (error) {
                console.error("Error occurred during the delete request:", error);
            }
        });
    });
}
//Delete Meal Button above



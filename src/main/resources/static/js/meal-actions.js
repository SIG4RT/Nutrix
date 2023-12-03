var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
//Delete Meal Button below 
export function initializeDeleteButtons() {
    const deleteButtons = document.querySelectorAll("[id^='deleteBtn-']"); // Select buttons with IDs starting with 'deleteBtn-'
    deleteButtons.forEach((button) => {
        button.addEventListener("click", () => __awaiter(this, void 0, void 0, function* () {
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
                const response = yield fetch(`/api/meal/${mealId}`, {
                    method: "DELETE",
                    headers: {
                        "Content-Type": "application/json",
                    },
                });
                if (response.ok) {
                    const closestTR = button.closest("tr"); //gets closest tableRow and deletes it have to redo it for accordion
                    if (closestTR) {
                        closestTR.remove();
                    }
                }
                else {
                    console.error("Failed to delete the meal");
                }
            }
            catch (error) {
                console.error("Error occurred during the delete request:", error);
            }
        }));
    });
}
//Delete Meal Button above
//# sourceMappingURL=meal-actions.js.map
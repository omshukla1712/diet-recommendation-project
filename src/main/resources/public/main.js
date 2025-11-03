document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("userForm");

  form.addEventListener("submit", async (event) => {
    event.preventDefault(); 
const user = {
  name: document.getElementById("name").value,
  age: parseInt(document.getElementById("age").value),
  height: parseFloat(document.getElementById("height").value),
  weight: parseFloat(document.getElementById("weight").value),
  gender: document.getElementById("gender").value,
  activityLevel: "Moderate", 
  goal: document.getElementById("goal").value
};

    try {
      const response = await fetch("https://your-railway-app-name.up.railway.app/addUser", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(user)
      });

      const result = await response.json();

      if (response.ok) {
        alert("User added successfully!");
        window.location.href = "recommendation.html"; 
      } else {
        alert("Error: " + (result.error || "Unable to add user."));
      }
    } catch (error) {
      console.error("Error:", error);
      alert("Unable to connect to server.");
    }
  });
});

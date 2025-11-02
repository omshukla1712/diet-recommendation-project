document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("userForm"); // ✅ Correct ID

  form.addEventListener("submit", async (event) => {
    event.preventDefault(); // prevent page reload

    // ✅ Create user object based on current HTML fields
    const user = {
      name: "Anonymous", // no 'name' field in HTML yet
      age: parseInt(document.getElementById("age").value),
      height: parseFloat(document.getElementById("height").value),
      weight: parseFloat(document.getElementById("weight").value),
      gender: document.getElementById("gender").value,
      activityLevel: "Moderate", // placeholder since not in form
      goal: document.getElementById("goal").value
    };

    try {
      const response = await fetch("http://localhost:8080/addUser", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(user)
      });

      const result = await response.json();

      if (response.ok) {
        alert("User added successfully!");
        window.location.href = "recommendation.html"; // go to next page
      } else {
        alert("Error: " + (result.error || "Unable to add user."));
      }
    } catch (error) {
      console.error("Error:", error);
      alert("Unable to connect to server.");
    }
  });
});

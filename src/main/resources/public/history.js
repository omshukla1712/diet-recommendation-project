document.addEventListener("DOMContentLoaded", async () => {
  console.log("✅ history.js loaded");
  const historyDiv = document.getElementById("history");
  historyDiv.innerHTML = "<p>Loading user history...</p>";

  try {
    const response = await fetch("https://your-railway-app-name.up.railway.app/addUser");
    const users = await response.json();

    if (response.ok && users.length > 0) {
      historyDiv.innerHTML = "";
      users.forEach(user => {
        const card = document.createElement("div");
        card.classList.add("history-card");
        card.innerHTML = `
          <h3>${user.name}</h3>
          <p>Age: ${user.age}</p>
          <p>Height: ${user.height} cm</p>
          <p>Weight: ${user.weight} kg</p>
          <p>Goal: ${user.goal}</p>
          <p>Activity Level: ${user.activityLevel}</p>
        `;
        historyDiv.appendChild(card);
      });
    } else {
      historyDiv.innerHTML = "<p>No users found.</p>";
    }
  } catch (error) {
    console.error("Error loading users:", error);
    historyDiv.innerHTML = "<p>⚠️ Failed to load data. Please try again later.</p>";
  }
});

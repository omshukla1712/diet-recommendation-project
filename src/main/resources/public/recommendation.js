document.addEventListener("DOMContentLoaded", async () => {
  const listDiv = document.getElementById("recommendationList");

  try {
    const response = await fetch("http://localhost:8080/users");
    const users = await response.json();

    if (users.length === 0) {
      listDiv.innerHTML = "<p>No users found. Please add your details first.</p>";
      return;
    }
    const user = users[users.length - 1];
    const { name, age, height, weight, gender, goal } = user;

    const bmi = weight / Math.pow(height / 100, 2);
    let recommendation = "";

    if (goal.toLowerCase().includes("loss")) {
      recommendation = "Focus on a calorie deficit with lean protein, vegetables, and healthy fats.";
    } else if (goal.toLowerCase().includes("gain")) {
      recommendation = "Increase protein intake and include complex carbs like brown rice, oats, and beans.";
    } else {
      recommendation = "Maintain a balanced diet with moderate portions of all nutrients.";
    }

    listDiv.innerHTML = `
      <div class="user-info">
        <h3>Hello, ${name}!</h3>
        <p><strong>Age:</strong> ${age}</p>
        <p><strong>Gender:</strong> ${gender}</p>
        <p><strong>Height:</strong> ${height} cm</p>
        <p><strong>Weight:</strong> ${weight} kg</p>
        <p><strong>BMI:</strong> ${bmi.toFixed(1)}</p>
        <p><strong>Goal:</strong> ${goal}</p>
      </div>
      <div class="recommendation-text">
        <h3>Recommended Plan:</h3>
        <p>${recommendation}</p>
      </div>
    `;
  } catch (error) {
    console.error("Error fetching data:", error);
    listDiv.innerHTML = "<p>Unable to load recommendations. Please try again later.</p>";
  }
});

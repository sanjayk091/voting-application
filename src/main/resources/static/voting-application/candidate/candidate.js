function registerCandidate(formId, endpoint) {
  const form = document.getElementById(formId);

  form.addEventListener("submit", function (e) {
    e.preventDefault();

    const candidate = {
      name: document.getElementById("name").value.trim(),
      partyName: document.getElementById("partyName").value.trim(),
      email: document.getElementById("email").value.trim(),
      mobileNumber: document.getElementById("mobileNumber").value.trim(),
      constituency: document.getElementById("constituency").value.trim(),
      age: parseInt(document.getElementById("age").value)
    };

    fetch(endpoint, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(candidate)
    })
    .then(response => {
      if (!response.ok) {
        return response.text().then(text => { throw new Error(text); });
      }
      return response.json();
    })
    .then(result => {
      alert("✅ Registration successful!");
      form.reset();
    })
    .catch(error => {
      alert(`Registration failed: ${error.message}`);
    });
  });
}

// Initialize
document.addEventListener("DOMContentLoaded", function () {
  registerCandidate("candidateForm", "/api/candidate/register");
});

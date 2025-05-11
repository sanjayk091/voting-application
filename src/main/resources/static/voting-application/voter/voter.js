function registerVoter(formId, endpoint) {
  const form = document.getElementById(formId);
  const alertMessage = document.getElementById('alertMessage');

  form.addEventListener('submit', function (e) {
    e.preventDefault();

    const name = document.getElementById('name').value.trim();
    const mobileNumber = document.getElementById('mobileNumber').value.trim();
    const email = document.getElementById('email').value.trim();
    const governmentId = document.getElementById('governmentId').value.trim();

    const nameRegex = /^[a-zA-Z\s]+$/;
    const mobileRegex = /^[0-9]{10}$/;
    const governmentIdRegex = /^[0-9]{12}$/;

    alertMessage.innerHTML = '';
    alertMessage.style.color = 'red';

    if (!name || !nameRegex.test(name)) {
      alertMessage.innerHTML = "Invalid Name. Only alphabets and spaces are allowed.";
      return;
    }

    if (!mobileRegex.test(mobileNumber)) {
      alertMessage.innerHTML = "Mobile number must be 10 digits.";
      return;
    }

    if (!email || !email.includes('@')) {
      alertMessage.innerHTML = "Invalid email format.";
      return;
    }

    if (!governmentIdRegex.test(governmentId)) {
      alertMessage.innerHTML = "Government ID must be 12 digits.";
      return;
    }

    const voterData = {
      name,
      mobileNumber,
      email,
      governmentId,
      hasVoted: false
    };

    fetch(endpoint, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(voterData),
    })
      .then(response => {
        if (!response.ok) {
          return response.text().then(text => { throw new Error(text); });
        }
        return response.json();
      })
      .then(data => {
        alertMessage.innerHTML = "Voter Registered Successfully!";
        alertMessage.style.color = 'green';
        form.reset();
      })
      .catch(error => {
        alertMessage.innerHTML = "Error: " + error.message;
        alertMessage.style.color = 'red';
      });
  });
}

// Initialize when DOM is ready
document.addEventListener('DOMContentLoaded', function () {
  registerVoter('voterForm', '/api/voter/register');
});

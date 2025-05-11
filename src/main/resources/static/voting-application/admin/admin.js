function startSession() {
    const startTime = document.getElementById("startTime").value;
    const endTime = document.getElementById("endTime").value;

    if (!startTime || !endTime) {
        alert("Please provide both start and end times.");
        return;
    }

    fetch("/api/admin/voting-session/start", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ startTime, endTime })
    })
    .then(async response => {
        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.message || "Unknown error occurred.");
        }
        return response.text();
    })
    .then(msg => alert("Voting Session Started."))
    .catch(err => alert(err.message));
}

function endSession() {
    fetch("/api/admin/voting-session/end", {
        method: "POST"
    })
    .then(async response => {
        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.message || "Unknown error occurred.");
        }
        return response.text();
    })
    .then(msg => alert(msg))
    .catch(err => alert(err.message));
}

function viewResults() {
    fetch("/api/admin/result")
    .then(async response => {
        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.message || "Unknown error occurred.");
        }
        return response.json();
    })
    .then(data => {
        const tbody = document.getElementById("resultsBody");
        tbody.innerHTML = "";

        if (data.length === 0) {
            tbody.innerHTML = "<tr><td colspan='4'>No results available</td></tr>";
            return;
        }

        data.forEach(result => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${result.candidateId}</td>
                <td>${result.name}</td>
                <td>${result.partyName}</td>
                <td>${result.totalVotes}</td>
            `;
            tbody.appendChild(row);
        });
    })
    .catch(err => {
        alert(err.message);
    });
}

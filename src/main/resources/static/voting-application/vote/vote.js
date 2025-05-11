document.addEventListener("DOMContentLoaded", () => {
    fetchCandidates();
});

function fetchCandidates() {
    fetch("/api/candidate")
        .then(res => res.json())
        .then(data => {
            const tbody = document.getElementById("candidateTableBody");
            tbody.innerHTML = "";

            data.forEach(candidate => {
                const row = document.createElement("tr");

                row.innerHTML = `
                    <td>${candidate.id}</td>
                    <td>${candidate.name}</td>
                    <td>${candidate.partyName}</td>
                    <td>
                        <button onclick="castVote(${candidate.id})" id="btn-${candidate.id}">Cast Vote</button>
                    </td>
                `;

                tbody.appendChild(row);
            });
        })
        .catch(error => {
            document.getElementById("candidateTableBody").innerHTML = "<tr><td colspan='4'>Failed to load candidates.</td></tr>";
            console.error("Error fetching candidates:", error);
        });
}

function castVote(candidateId) {
    const voterId = document.getElementById("voterId").value;

    if (!voterId) {
        const message = "Please enter your Voter ID.";
        alert(message); // 🔴 Validation message
        return;
    }

    fetch("/api/votes/cast", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ voterId: Number(voterId), candidateId })
    })
    .then(async response => {
        if (!response.ok) {
            const errorData = await response.json();
            const errorMsg = errorData.message || "Something went wrong";
            throw new Error(errorMsg);
        }
        return response.text();
    })
    .then(message => {
        alert(message); // ✅ Success message
        document.getElementById(`btn-${candidateId}`).disabled = true;
    })
    .catch(error => {
        alert(error.message); // ❌ Error from backend
    });
}

document.getElementById('emiForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const loanAmount = document.getElementById('loanAmount').value;
    const rateOfInterest = document.getElementById('rateOfInterest').value;
    const numberOfYears = document.getElementById('numberOfYears').value;

    const emiCalculation = {
        loanAmount: parseFloat(loanAmount),
        rateOfIntrest: parseFloat(rateOfInterest),
        numberOfYears: parseFloat(numberOfYears)
    };


    fetch('http://localhost:8080/calculate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(emiCalculation)
    })
        .then(response => response.json())
        .then(data => {

            document.getElementById('emiValue').textContent = `₹${data.toFixed(2)}`;
            document.getElementById('result').classList.remove('hidden');
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById('result').textContent = 'An error occurred while calculating the EMI.';
        });
});

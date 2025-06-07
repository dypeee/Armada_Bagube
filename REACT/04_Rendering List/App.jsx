import './App.css'

function App() {

    let numbers = [42, 7, 13, 100, 15];
    let randomNumbers = [];
    for (let i = 0; i < 30; i++) {
        randomNumbers.push(Math.floor(Math.random() * 9000));
    }
    const orderedList = numbers.map((number, index) => {
        return <li key={index}>{number}</li>;
    })

    const unorderedList = randomNumbers.map((randomNumber, index) => {

        return <li key={index}>{randomNumber}</li>;

    })


    return (
        <>
            <div>
                <ol>
                    {orderedList}
                </ol>
                <ol>
                    {unorderedList}
                </ol>
            </div>
        </>
    )
}

export default App

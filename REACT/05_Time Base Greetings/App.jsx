import morningImage from './assets/morning.jpg';
import afternoonImage from './assets/afternoon.jpg';
import eveningImage from './assets/evening.jpg';
import nightImage from './assets/night.jpg';
import './App.css'


function App() {

    let hour = new Date().getHours();
    let minutes = new Date().getMinutes();
    let currentTime = hour + ":" + minutes;
    let display;

    if (hour >= 5 && hour < 12) {
        display = {
            url: morningImage,
            description: "Morning Image",
            greeting: "Good Morning",
            meridiem: "AM",
        };
    } else if (hour >= 12 && hour < 17) {
        display = {
            url: afternoonImage,
            description: "Afternoon Image",
            greeting: "Good Afternoon",
            meridiem: "PM",
        };
    } else if (hour >= 17 && hour < 21) {
        display = {
            url: eveningImage,
            description: "Evening Image",
            greeting: "Good Evening",
            meridiem: "PM",
        };
    } else {
        display = {
            url: nightImage,
            description: "Night Image",
            greeting: "Good Night",
            meridiem: "PM",
        };
    }

    return (
        <>
            <div>
                <div className='background'>
                    <img src={display.url} alt={display.description} />
                </div>
                <h1>{display.greeting}</h1>
                <h2>{currentTime} {display.meridiem}</h2>
            </div>
        </>
    )
}

export default App

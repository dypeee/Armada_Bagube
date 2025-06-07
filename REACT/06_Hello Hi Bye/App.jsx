import './App.css';

function App() {
	let message;

	function helloMessage(event) {
		let container = document.getElementById("modal");
		message = "Hello!";
		document.getElementById("msg").textContent = message;
		container.style.display = "flex";
	}

	function hiMessage(event) {
		let container = document.getElementById("modal");
		message = "Hi!";
		document.getElementById("msg").textContent = message;
		container.style.display = "flex";
	}

	function byeMessage(event) {
		let container = document.getElementById("modal");
		message = "Bye!";
		document.getElementById("msg").textContent = message;
		container.style.display = "flex";
	}

	function closeModal(event) {
		let container = document.getElementById("modal");
		container.style.display = "none";
	}

	return (
		<>
			<main>
				<button onClick={helloMessage}>Hello!</button>
				<button onClick={hiMessage}>Hi!</button>
				<button onClick={byeMessage}>Bye!</button>
			</main>

			<div id='modal' style={{ display: "none" }}>
				<dialog>
					<p>You clicked <span id="msg"></span></p>
					<div>
						<button onClick={closeModal}>Close</button>
					</div>

				</dialog>
			</div>


		</>
	);
}

export default App;

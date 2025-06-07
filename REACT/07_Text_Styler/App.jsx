import React from 'react';
import './App.css';

function App() {
	let fontWeight = 'normal';
	let fontStyle = 'normal';
	let textDecoration = 'none';
	let fontSize = '16px';
	let color = 'black';

	function makeBold() {
		const text = document.getElementById('styledText');
		fontWeight = text.style.fontWeight === 'bold' ? 'normal' : 'bold';
		text.style.fontWeight = fontWeight;
	}

	function makeItalic() {
		const text = document.getElementById('styledText');
		fontStyle = text.style.fontStyle === 'italic' ? 'normal' : 'italic';
		text.style.fontStyle = fontStyle;
	}

	function makeUnderline() {
		const text = document.getElementById('styledText');
		textDecoration = text.style.textDecoration === 'underline' ? 'none' : 'underline';
		text.style.textDecoration = textDecoration;
	}

	function changeFontSize(size) {
		const text = document.getElementById('styledText');
		fontSize = text.style.fontSize == size ? '16px' : size;
		text.style.fontSize = size;
	}

	function changeColor(newColor) {
		const text = document.getElementById('styledText');
		color = text.style.color == newColor ? 'black' : newColor;
		text.style.color = color;
	}

	return (
		<main className="app">
			<h1>Text Styler</h1>

			<section className="textStyle">
				<button onClick={makeBold}>Bold</button>
				<button onClick={makeItalic}>Italic</button>
				<button onClick={makeUnderline}>Underline</button>
			</section>

			<section className="fontSize">
				<button onClick={() => changeFontSize('14px')}>Font Size 14px</button>
				<button onClick={() => changeFontSize('18px')}>Font Size 18px</button>
				<button onClick={() => changeFontSize('24px')}>Font Size 24px</button>
			</section>

			<section className="textColor">
				<button onClick={() => changeColor('red')}>Red</button>
				<button onClick={() => changeColor('blue')}>Blue</button>
				<button onClick={() => changeColor('green')}>Green</button>
			</section>

			<section className="textBox">
				<p id="styledText">
					This is the text that will be styled dynamically based on the buttons clicked.
				</p>
			</section>
		</main>
	);
}
export default App;

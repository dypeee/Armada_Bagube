import Logo from './components/Logo';
import './App.css';
import SignIn from './components/SignIn';
import SignUp from './components/Signup';


function App() {
	return (
		<>
			<main>
				<section className='authSection'>
					<SignIn />
					<SignUp />
				</section>
				<section className='logoSection'>
					<Logo/>
				</section>
			</main>
		</>
	);
}
export default App;

import logoImage from '../assets/logo.png'
import './css/Logo.css'

function Logo() {

    const logo = {
        url: logoImage,
        description: "Haven Logo",
    };

    return (
        <>
            <div className='logo_section'>
                <h1>HAVEN</h1>
                <p>Manage your property has never been easier!</p>
                <img src={logo.url} alt={logo.description} />
            </div>
        </>
    );
}

export default Logo
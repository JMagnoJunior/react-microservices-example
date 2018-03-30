import React from "react"; 
import {Footer} from './styles';

function Layout({title, renderContent}){
    return (
       <div>
              <header>      
                <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                    <a className="navbar-brand" href="#">FindMyPlace</a>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item active">
                        <a className="nav-link" href="#">Home <span className="sr-only">(current)</span></a>
                        </li>
                        <li className="nav-item">
                        <a className="nav-link" href="#">Link</a>
                        </li>
                        <li className="nav-item">
                        <a className="nav-link disabled" href="#">Disabled</a>
                        </li>
                    </ul>
                    <form className="form-inline mt-2 mt-md-0">
                        <input className="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" />
                        <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                    </div>
                </nav>
                </header>

            <br />
            <main role="main" className="container">
            <div className="row">
            <div className="col mt-5">
            <h1 >{title}</h1>
            </div>
            </div>
            {renderContent()}
             </main>

           <Footer classNameName="footer">
            <div className="container">
                <span className="text-muted">Developed by Magno Junior</span>
            </div>
            </Footer>
            
        </div>
    )
}

export function withLayout(title="FindMyPlace"){
    return Component => props => (
        <div>
        <Layout title={title} renderContent={() => (  <Component {...props} /> ) } >        
        </Layout>
        </div>
    );
}
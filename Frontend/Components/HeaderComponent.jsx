import React, { Component } from 'react'

export default class HeaderComponent extends Component {
    constructor(props){
        super(props)
        this.state = {

        }
    }
    render() {
    return (
      <div>
        <nav className='navbar navbar-expand-md navbar-dark bg-dark'>
            <div className='.header'> <a href="" className='navbar-brand'>ACADEMIA</a></div>
        </nav>
      </div>
    )
  }
}

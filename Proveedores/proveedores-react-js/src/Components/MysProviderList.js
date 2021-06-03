import React, { Component } from 'react'

export default class MysProviderList extends Component
{
    state = {
        providers: []
    }

    componentDidMount()
    {
        var data = [
            { 
                id: 1, 
                nombre: 'Juan David Sierra', 
                fechaRegistro: '15/12/2019', 
                telefono: '1234567', 
                direccion: 'Calle Luna, Calle Sol' 
            },
            { 
                id: 3, 
                nombre: 'Sanider Lopez Mendoza', 
                fechaRegistro: '15/12/2019', 
                telefono: '5378941',
                direccion: 'Turbaco'
            },
            {
                id: 4, 
                nombre: 'Jesus Cabrera', 
                fechaRegistro: '15/12/2019', 
                telefono: '8273695', 
                direccion: 'Medellin' 
            }
        ]

        this.setState({providers: data});
    }

    render()  {
        return (
            <div className="container">
                <div className="card">
                    <div className="card-header d-flex justify-content-between"> 
                        <h3> Providers </h3> 
                        <button className="btn btn-primary"> New </button>
                    </div>                    
                    <div  className="card-body">
                        <div className="table-responsive">
                            <table className="table table-hover">
                                <thead>
                                    <tr className="text-center">
                                        <th> Name </th>
                                        <th> Fecha De Registro </th>
                                        <th> Telefono </th>
                                        <th> Dirección </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        this.state.providers.map(provider=>(
                                            <tr className="text-center" key={provider.id}>
                                                <td>{provider.nombre} </td>
                                                <td> {provider.fechaRegistro} </td>
                                                <td> {provider.telefono} </td>
                                                <td> {provider.direccion} </td>
                                                <td>
                                                    <a className="btn btn-warning" 
                                                        href={"/add/" + provider.id} > Edit </a>
                                                    <button className="btn btn-danger" 
                                                        style={{ marginLeft: "1rem"}}
                                                        idprovider={provider.id}
                                                        nameprovuder={provider.nombre} > Delete </button>
                                                </td>
                                            </tr>
                                        ))
                                    }
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
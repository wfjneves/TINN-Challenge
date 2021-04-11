import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ListVeiculoItem } from './list-veiculo-item';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { StatusVendaCarroDto } from './status-venda-carro-dto';
import { ListVeiculoComponent } from './list-veiculo/list-veiculo.component';

@Injectable({
  providedIn: 'root'
})
export class VeiculoService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<ListVeiculoItem[]> {
    return this.http.get<ListVeiculoItem[]>('http://localhost:8181/veiculos',this.getOptions()).pipe(catchError(this.handleError('veiculoService.getAll', [])));
  }

  getById(id: number | any): Observable<ListVeiculoItem> {
    return this.http.get<ListVeiculoItem>('http://localhost:8181/veiculos/'+id,this.getOptions()).pipe(catchError(this.handleErrorObject('veiculoService.getById')));
  }

  atualizarStatusDeVenda(status: StatusVendaCarroDto): Observable<Object>{
    return this.http.patch("http://localhost:8181/veiculos/"+status.id, JSON.stringify(status), this.getOptions()).pipe(catchError(this.handleError('veiculoService.atualizarStatusDeVenda', [])));
  }

  excluir(id: number): Observable<Object>{
    return this.http.delete("http://localhost:8181/veiculos/"+id, this.getOptions()).pipe(catchError(this.handleError('veiculoService.excluir', [])));
  }

  
  cadastrar(veiculo: ListVeiculoItem): Observable<ListVeiculoItem> {
    return  this.http.post<ListVeiculoItem>("http://localhost:8181/veiculos", JSON.stringify(veiculo), this.getOptions()).pipe(catchError(this.handleErrorObject('veiculoService.cadastrar')));
  }

  
   atualizar(veiculo: ListVeiculoItem): Observable<ListVeiculoItem> {
    return  this.http.put<ListVeiculoItem>("http://localhost:8181/veiculos/"+veiculo.id, JSON.stringify(veiculo), this.getOptions()).pipe(catchError(this.handleErrorObject('veiculoService.atualizar')));
  }
 


  handleError(operation= 'operation', result: ListVeiculoItem[]){
    return (error: any): Observable<ListVeiculoItem[]> =>{
      console.error("Ao excecutar a operacao = "+ operation+ " Aconteceu esse error: "+ JSON.stringify(error));
      return  of(result);
    }

  }

handleErrorObject(operation= 'operation'){
    return (error: any): Observable<ListVeiculoItem> =>{
      console.error("Ao excecutar a operacao = "+ operation+ " Aconteceu esse error: "+ JSON.stringify(error));
      return of({ id: null, veiculo: '', marca: '', ano: null, descricao: '', vendido: false, created: ''  }); 
    }

  }

  getOptions() {
    return  {
			headers: new HttpHeaders({
				'Content-Type': 'application/json',
			})
		};
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { ListVeiculoItem } from './list-veiculo-item';
import { Observable, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { StatusVendaCarroDto } from './status-venda-carro-dto';


@Injectable({
  providedIn: 'root'
})
export class VeiculoService {

  constructor(private http: HttpClient) { }

  findVeiculosPaginado(filtro: any, pageIndex: any, pageSize: any, sortField: string | undefined, sortDirection: string | undefined ): Observable<any>{
    let params = new HttpParams().set('page', pageIndex).set('size', pageSize);
    if (sortField) {
      params = params.set("sort",sortField+","+sortDirection);
    }
    
    if (filtro.marca) {
      params = params.set('marca', filtro.marca);
    }

    if (filtro.veiculo) {
      params = params.set('veiculo',filtro.veiculo);
    }

    if (filtro.ano) {
      params = params.set('ano', filtro.ano);
      
    }

    if (filtro.descricao) {
      params = params.set('descricao', filtro.descricao);
    }

    if (filtro.vendido) {
      params = params.set('vendido', filtro.vendido);
    }

    if (filtro.dataInicioCriacao) {
      params = params.set('dataInicioCriacao', filtro.dataInicioCriacao);
    }

    if (filtro.dataFinalCriacao) {
        params = params.set('dataFinalCriacao', filtro.dataFinalCriacao);
    }

    let options = {
      params,
      headers: this.getOptions().headers
    };
      return this.http.get<any>('http://localhost:8181/veiculos/find', options);
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

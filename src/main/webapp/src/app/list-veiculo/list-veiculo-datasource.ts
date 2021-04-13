import { DataSource } from '@angular/cdk/collections';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { BehaviorSubject, merge, Observable, of as observableOf } from 'rxjs';
import { ListVeiculoItem } from './../list-veiculo-item';
import { VeiculoService } from './../veiculo.service';



// TODO: replace this with real data from your application
const EXAMPLE_DATA: ListVeiculoItem[] = [];

/**
 * Data source for the ListVeiculo view. This class should
 * encapsulate all logic for fetching and manipulating the displayed data
 * (including sorting, pagination, and filtering).
 */
export class ListVeiculoDataSource extends DataSource<ListVeiculoItem> {
  data: BehaviorSubject<ListVeiculoItem[]> = new BehaviorSubject<ListVeiculoItem[]>([]);
  paginator: MatPaginator | undefined;
  sort: MatSort | undefined;
  size: number = 0;

  constructor(private veiculoService: VeiculoService) {
    super();    
  }

  consultar(filtro: any){    
    this.veiculoService.findVeiculosPaginado(filtro, this.paginator?.pageIndex, this.paginator?.pageSize, this.sort?.active, this.sort?.direction ).subscribe(veiculos => {
      this.size = veiculos.totalElements;
      this.data.next(veiculos.content)
      } );
  }

  /**
   * Connect this data source to the table. The table will only update when
   * the returned stream emits new items.
   * @returns A stream of the items to be rendered.
   */
  connect(): Observable<ListVeiculoItem[]> {
    console.log('connect 1')
    return this.data.asObservable();
  }

  /**
   *  Called when the table is being destroyed. Use this function, to clean up
   * any open connections or free any held resources that were set up during connect.
   */
  disconnect(): void {}


}
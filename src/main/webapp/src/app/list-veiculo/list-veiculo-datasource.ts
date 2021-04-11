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
    this.consultar();
  }
  
  consultar(){
    this.size = 2; //Consultar a quantidade de registros
    this.consultarInterno();
  }


  private consultarInterno(){
    this.veiculoService.getAll().subscribe(veiculos => {
      this.size = veiculos.length;
      this.data.next(veiculos)
      } );
  }

  /**
   * Connect this data source to the table. The table will only update when
   * the returned stream emits new items.
   * @returns A stream of the items to be rendered.
   */
  connect(): Observable<ListVeiculoItem[]> {
    return this.data.asObservable();
    /*if (this.paginator && this.sort) {
      // Combine everything that affects the rendered data into one update
      // stream for the data-table to consume.
      return merge(observableOf(this.data), this.paginator.page, this.sort.sortChange)
        .pipe(map(() => {
          return this.getPagedData(this.getSortedData([...this.data ]));
        }));
    } else {
      throw Error('Please set the paginator and sort on the data source before connecting.');
    }*/
  }

  /**
   *  Called when the table is being destroyed. Use this function, to clean up
   * any open connections or free any held resources that were set up during connect.
   */
  disconnect(): void {}

  /**
   * Paginate the data (client-side). If you're using server-side pagination,
   * this would be replaced by requesting the appropriate data from the server.
   */
  private getPagedData(data: ListVeiculoItem[]): ListVeiculoItem[] {    
    console.log("Aconteceu pageData");
    if (this.paginator) {
      const startIndex = this.paginator.pageIndex * this.paginator.pageSize;
      return data.splice(startIndex, this.paginator.pageSize);
    } else {
      return data;
    }    
  }

  /**
   * Sort the data (client-side). If you're using server-side sorting,
   * this would be replaced by requesting the appropriate data from the server.
   */
  private getSortedData(data: ListVeiculoItem[]): ListVeiculoItem[] {
    if (!this.sort || !this.sort.active || this.sort.direction === '') {
      return data;
    }
    return data.sort((a, b) => {
      const isAsc = this.sort?.direction === 'asc';
      switch (this.sort?.active) {
        case 'veiculo': return compare(a.veiculo, b.veiculo, isAsc);
        case 'marca': return compare(+a.marca, +b.marca, isAsc);
        case 'ano': return compare(+a.ano, +b.ano, isAsc);
        case 'vendido': return compare(+a.vendido, +b.vendido, isAsc);
        default: return 0;
      }
    });
  }
}

/** Simple sort comparator for example ID/Name columns (for client-side sorting). */
function compare(a: string | number | boolean, b: string | number | boolean, isAsc: boolean): number {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}

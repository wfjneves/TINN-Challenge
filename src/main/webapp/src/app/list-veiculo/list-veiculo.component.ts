import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable } from '@angular/material/table';
import { ListVeiculoDataSource } from './list-veiculo-datasource';
import { ListVeiculoItem } from './../list-veiculo-item';
import { VeiculoService }  from './../veiculo.service';    
import { StatusVendaCarroDto } from './../status-venda-carro-dto';

@Component({
  selector: 'app-list-veiculo',
  templateUrl: './list-veiculo.component.html',
  styleUrls: ['./list-veiculo.component.css']
})
export class ListVeiculoComponent implements AfterViewInit {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatTable) table!: MatTable<ListVeiculoItem>;
  dataSource: ListVeiculoDataSource;
  veiculo: ListVeiculoItem = {} as ListVeiculoItem;
  filtro: any = {};

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['veiculo', 'marca', 'ano', 'vendido', 'acoes'];

  constructor(private veiculoService: VeiculoService) {    
    this.dataSource = new ListVeiculoDataSource(veiculoService);    
  }
  
  excluir(idUsuario: number){
    if(confirm("Deseja realmente excluir o veiculo?")){
      this.veiculoService.excluir(idUsuario).subscribe(obj => {
        this.dataSource.consultar(this.filtro);
      })
    }
  }
  
  atualizarStatusDeVenda(idUsuario: number, status: boolean){
    var statusVendaDto: StatusVendaCarroDto = { id: idUsuario, statusDeVenda: status };
    this.veiculoService.atualizarStatusDeVenda(statusVendaDto).subscribe(obj => {
      this.dataSource.consultar(this.filtro);
    });
  }

  cadastrar(){
    this.veiculoService.cadastrar(this.veiculo).subscribe((obj) => {
      this.veiculo.id = obj.id;
      alert("Veiculo cadastrado com sucesso");
    });
  }

  atualizar(){
    this.veiculoService.atualizar(this.veiculo).subscribe((obj) => {
      alert("Veiculo atualizado com sucesso");
    });
  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
    this.paginator.page.subscribe(() => {
      this.dataSource.consultar({});
    })
    this.sort.sortChange.subscribe(() => {
      this.dataSource.consultar({});
    });
    this.dataSource.consultar({});
  }
}

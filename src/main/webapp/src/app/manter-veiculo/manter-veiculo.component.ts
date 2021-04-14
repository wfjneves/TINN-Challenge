import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ListVeiculoItem } from './../list-veiculo-item';
import { VeiculoService } from './../veiculo.service';

@Component({
  selector: 'app-manter-veiculo',
  templateUrl: './manter-veiculo.component.html',
  styleUrls: ['./manter-veiculo.component.css']
})
export class ManterVeiculoComponent {
  id: any = null;
  veiculoForm = this.fb.group({
    veiculo: [null, Validators.required],
    marca: [null, Validators.required],
    ano: [null, Validators.required],
    descricao: [null, Validators.required],
    vendido: [false, null]
  });
  mensagemError: string = '';

  constructor(private fb: FormBuilder, private veiculoService: VeiculoService, private route: ActivatedRoute, private roteador: Router) {
    this.id = this.route.snapshot.paramMap.get('id');
    if (this.id) {
      this.veiculoService.getById(this.id).subscribe((veiculo) => {
        this.veiculoForm.controls.veiculo.setValue(veiculo.veiculo);
        this.veiculoForm.controls.marca.setValue(veiculo.marca);
        this.veiculoForm.controls.descricao.setValue(veiculo.descricao);
        this.veiculoForm.controls.ano.setValue(veiculo.ano);
        this.veiculoForm.controls.vendido.setValue(veiculo.vendido);
      })
    }
  }

  onSubmit(): void {
    let newVeiculo: ListVeiculoItem = {
      veiculo: this.veiculoForm.controls.veiculo.value, 
      marca: this.veiculoForm.controls.marca.value,
      descricao: this.veiculoForm.controls.descricao.value ,  
      ano:this.veiculoForm.controls.ano.value, 
      vendido: this.veiculoForm.controls.vendido.value 
     };
     if (this.id) {
       newVeiculo.id = this.id;
       this.veiculoService.atualizar(newVeiculo).pipe(catchError(this.handleErrorObject('veiculoService.cadastrar')))
       .subscribe((obj )=>{
         if (obj.id) {
           alert('Veiculo atualizado com sucesso!');
         }
       });
      }else{
        this.veiculoService.cadastrar(newVeiculo).pipe(catchError(this.handleErrorObject('veiculoService.atualizar')))
        .subscribe((obj)=>{
          this.id = obj.id;
          if (obj.id) {
            alert('Veiculo cadastrado com sucesso!');
            this.roteador.navigate(['/manter-veiculo',obj.id]);
          }
        });

     }  
    
  }
  
  handleErrorObject(operation= 'operation'){
    return (error: any): Observable<ListVeiculoItem> =>{
      if (error.status === 400 || error.status ===404 ) {
        this.mensagemError = error.error;
      }
      return of({ id: null, veiculo: '', marca: '', ano: null, descricao: '', vendido: false, created: ''  }); 
    }
    
  }
}

import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
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

  constructor(private fb: FormBuilder, private veiculoService: VeiculoService, private route: ActivatedRoute) {
    this.id = this.route.snapshot.paramMap.get('id');
    console.log("ID=> "+this.id);
    if (this.id) {
      this.veiculoService.getById(this.id).subscribe((veiculo) => {
        this.veiculoForm.controls.veiculo.setValue(veiculo.veiculo);
        this.veiculoForm.controls.marca.setValue(veiculo.marca);
        this.veiculoForm.controls.descricao.setValue(veiculo.marca);
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
       this.veiculoService.atualizar(newVeiculo).subscribe((obj )=>{
         alert('Veiculo atualizado com sucesso!');
       })
      }else{
        this.veiculoService.cadastrar(newVeiculo).subscribe((obj)=>{
          this.id = obj.id;
          alert('Veiculo cadastrado com sucesso!');
        })

     }  
    
  }
}

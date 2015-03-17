Title Add and Subtract                                                                      (AddSub.asm)

; CREATION DATE : 03/15/15
; REVISIONS : 1
; DATE : 03/16/15
; PROGRAM DESCRIPTION : This program evaluates the expression A = (A + B) - (C + D)

INCLUDE Irvine32.inc

    .data

    vA DWORD 80000h

    vB DWORD 20000h

    vC DWORD 30000h

    vD DWORD 40000h

    .code

    main PROC

              mov eax,vA
              mov ebx,vB
              mov ecx,vC
              mov edx,vD
              add  eax,ebx
              add ecx,edx
              sub eax,ecx
              call DumpRegs

              exit
   main ENDP
   END main

aus alt: X="category=false,active=false,directPosting=false,reconciliationAccount=false,type=false,categoryHelper=false,selectionColumn=false,vatKeyHelper=false,vatCodeHelper=false,fixVatKey=false,cashDiscountAccountVatMatrix=false,cashDiscountAccount=false,text=false,financeAccount=false,summaryAccount=false,assetAccountAfa=false,assetAccountGwg=false,assetAccountPartialAfa=false,assetAccountSpecialAfa=false,assetAccountValuePlus=false,skipForVatReport=false,createdTs=false,modifiedTs=false,creatorName=false,modifierName=false,assetAccountDivestiturePlus=false,assetAccountDivestitureMinus=false,datevAutomaticAccount=false"   

mach neu:   
echo $X | sed -E -e 's/([A-Za-z0-9_]+)=(true)/"\1"/g' -e 's/([A-Za-z0-9_]+)=(false)/"!\1"/g'   
   
   
oben ist X definiert es macht aus category=false den string !category